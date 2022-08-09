# Push images to ECR

# Create AWS Context
##### https://docs.docker.com/cloud/ecs-integration/#create-aws-context

# Set Environment Variables
#### Create .env and .env-aws files in the same directory as docker-compose-ecs.yml and set the values
## .env
#### The *_IMAGE variables should be set to the name of the ECR repository.
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

## .env-aws
###### **Replace PROJECTNAME with whatever you want the project name to be**
```
MEGABYTES_DB_USERNAME=
MEGABYTES_DB_PASSWORD=
MEGABYTES_DATASOURCE_URL=
MEGABYTES_LOCAL_URL=eureka.PROJECTNAME.local
JWT_SECRET=
```

# AWS ECS
###### **Replace PROJECTNAME with whatever you used in the .env file**
#### Create ECS Cluster
`docker compose -f docker-compose-ecs.yml -p PROJECTNAME up -d`

### Get the address of the LoadBalancer
Find the address on the AWS Console or run the command

`aws elbv2 describe-load-balancers --names ecsnlb --query "LoadBalancers[0].DNSName" --output text`

#### Destroy ECS Cluster
`docker compose -f docker-compose-ecs.yml -p PROJECTNAME down`
