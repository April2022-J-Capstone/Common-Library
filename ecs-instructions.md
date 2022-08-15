# Setup

Before pushing builds to AWS, there is some necessary setup.

## Install Docker and AWS CLI

##### https://docs.docker.com/engine/install/
##### https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html

## Configure AWS Credentials

##### https://docs.aws.amazon.com/cli/latest/userguide/getting-started-quickstart.html

## Authenticate Docker CLI to AWS ECR

##### https://docs.aws.amazon.com/AmazonECR/latest/userguide/getting-started-cli.html

Replace all `UPPERCASE` variables with the correct data before running.

`aws ecr get-login-password --region REGION | docker login --username AWS --password-stdin AWS_ACCOUNT_ID.dkr.ecr.REGION.amazonaws.com`

## Create AWS Context

##### https://docs.docker.com/cloud/ecs-integration/#create-aws-context

Using the default context, Docker Compose will create localhost builds. The AWS context is necessary for Docker Compose to create/delete new clusters on AWS. Default context may be necessary for building/pushing Docker images to ECR, but will need to be swapped to your AWS context before running Docker Compose.

`docker context use CONTEXT_NAME`

## Set Environment Variables

Create `.env` and `.env-aws` files in the same directory as `docker-compose-ecs.yml` and set the values.

#### .env

The `*_IMAGE` variables should be set to the name of the ECR repository.

```
AWS_ID=
AWS_REGION=
AUTH_IMAGE=
EUREKA_IMAGE=
GATEWAY_IMAGE=
USER_IMAGE=
RESTAURANT_IMAGE=
ORDER_IMAGE=
```

#### .env-aws

Replace `PROJECTNAME` with whatever you want the project name to be.

```
MEGABYTES_DB_USERNAME=
MEGABYTES_DB_PASSWORD=
MEGABYTES_DATASOURCE_URL=
MEGABYTES_LOCAL_URL=eureka.PROJECTNAME.local
JWT_SECRET=
```

# Deployment

After setup is completed, the steps below will allow the user to deploy the system to AWS.

## Build Services

All services should be built into packages before generating Docker images. When setting up a build script, ensure to set any dependent environment variables for the tests. `mvn package` will not generate a complete package without test success.

`mvn clean install` (Common Library)

`mvn clean package` (All services)

## Build Docker Images

For each service, `cd` into the root of the Dockerfile. Replace the `UPPERCASE` placeholders with the correct data. These commands may not work in your AWS Context, so run them as default context.

```
docker build --tag IMAGE:latest .
docker tag IMAGE:latest AWS_ACCOUNT_ID.dkr.ecr.REGION.amazonaws.com/IMAGE:latest
```

## Upload Docker Images to ECR

After the docker images have been built, you can upload them to the ECR repository like so:

`docker push AWS_ACCOUNT_ID.dkr.ecr.REGION.amazonaws.com/IMAGE:latest`

## Destroy Existing ECS Cluster

In order for the new cluster to properly deploy, the existing one must be deleted. Be sure to use your Docker AWS Context from now on.

`docker compose -f docker-compose-ecs.yml -p PROJECTNAME down`

## Create New ECS Cluster

Once the cluster is removed, you can regenerate it with the following command.

`docker compose -f docker-compose-ecs.yml -p PROJECTNAME up -d`

## Find the Load Balancer Address

Once the cluster is deployed, CloudFront needs an address to access. The following command should expose the address.

`aws elbv2 describe-load-balancers --names ecsnlb --query "LoadBalancers[0].DNSName" --output text`

## Modify CloudFront Origin

The load balancer should be used as the origin for the CloudFront CDN, which is used for enabling the frontends to send msgs to a consistent address.

Using the AWS web console it should be sufficient to edit the existing origin and replace the origin domain with the new load balancer.
