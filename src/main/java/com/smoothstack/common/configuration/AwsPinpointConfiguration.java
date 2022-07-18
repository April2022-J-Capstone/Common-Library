package com.smoothstack.common.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("cloud.aws.pinpoint")
public class AwsPinpointConfiguration {
    String appId;
    String accessKeyId;
    String secretKey;
    String emailFrom;
    String emailCharset;
    String smsFrom;
    String smsMsgType;
    String smsSenderId;
}
