package com.smoothstack.common.services.messaging;

import com.smoothstack.common.exceptions.SendMsgFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.pinpoint.PinpointClient;
import software.amazon.awssdk.services.pinpoint.model.*;

import java.util.HashMap;
import java.util.Map;

public class AwsPinpointService implements MessagingService {
    private static final Region DEFAULT_REGION = Region.US_EAST_1;

    @Value("${cloud.aws.pinpoint.appId}")
    private String appId;
    @Value("${cloud.aws.pinpoint.accessKeyId}")
    private String accessKeyId;
    @Value("${cloud.aws.pinpoint.secretKey}")
    private String secretKey;

    @Value("${cloud.aws.pinpoint.email.from}")
    private String emailFrom;
    @Value("${cloud.aws.pinpoint.email.charset}")
    private String emailCharset;

    @Value("${cloud.aws.pinpoint.sms.from}")
    private String smsFrom;
    @Value("${cloud.aws.pinpoint.sms.msgType}")
    private String smsMsgType;
    @Value("${cloud.aws.pinpoint.sms.senderId}")
    private String smsSenderId;

    private AwsBasicCredentials credentials;
    private PinpointClient client;

    @Autowired
    public AwsPinpointService() {
        credentials = AwsBasicCredentials.create(accessKeyId, secretKey);
        client = PinpointClient.builder().region(DEFAULT_REGION)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

    public void sendEmail(String email, String subject, String htmlBody) throws SendMsgFailureException {
        try {
            Map<String,AddressConfiguration> addressMap = new HashMap<>();
            AddressConfiguration configuration = AddressConfiguration.builder()
                    .channelType(ChannelType.EMAIL)
                    .build();

            addressMap.put(email, configuration);
            SimpleEmailPart emailPart = SimpleEmailPart.builder()
                    .data(htmlBody)
                    .charset(this.emailCharset)
                    .build() ;

            SimpleEmailPart subjectPart = SimpleEmailPart.builder()
                    .data(subject)
                    .charset(this.emailCharset)
                    .build() ;

            SimpleEmail simpleEmail = SimpleEmail.builder()
                    .htmlPart(emailPart)
                    .subject(subjectPart)
                    .build();

            EmailMessage emailMessage = EmailMessage.builder()
                    .body(htmlBody)
                    .fromAddress(this.emailFrom)
                    .simpleEmail(simpleEmail)
                    .build();

            DirectMessageConfiguration directMessageConfiguration = DirectMessageConfiguration.builder()
                    .emailMessage(emailMessage)
                    .build();

            MessageRequest messageRequest = MessageRequest.builder()
                    .addresses(addressMap)
                    .messageConfiguration(directMessageConfiguration)
                    .build();

            SendMessagesRequest messagesRequest = SendMessagesRequest.builder()
                    .applicationId(this.appId)
                    .messageRequest(messageRequest)
                    .build();

            // TODO: Read data from the response
            client.sendMessages(messagesRequest);
        } catch (PinpointException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            throw new SendMsgFailureException();
        }
    }

    public void sendSMS(String phone, String message) throws SendMsgFailureException {
        try {
            Map<String, AddressConfiguration> addressMap = new HashMap<>();

            AddressConfiguration addConfig = AddressConfiguration.builder()
                    .channelType(ChannelType.SMS)
                    .build();

            addressMap.put(phone, addConfig);

            SMSMessage smsMessage = SMSMessage.builder()
                    .body(message)
                    .messageType(this.smsMsgType)
                    .originationNumber(this.smsFrom)
                    .senderId(this.smsSenderId)
                    .build();

            // Create a DirectMessageConfiguration object
            DirectMessageConfiguration direct = DirectMessageConfiguration.builder()
                    .smsMessage(smsMessage)
                    .build();

            MessageRequest msgReq = MessageRequest.builder()
                    .addresses(addressMap)
                    .messageConfiguration(direct)
                    .build();

            // create a  SendMessagesRequest object
            SendMessagesRequest request = SendMessagesRequest.builder()
                    .applicationId(appId)
                    .messageRequest(msgReq)
                    .build();

            // TODO: Read data from the response
            client.sendMessages(request);
        } catch (PinpointException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            throw new SendMsgFailureException();
        }
    }
}
