package com.smoothstack.common.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.converter.RsaKeyConverters;

import java.io.IOException;
import java.io.InputStream;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Data
@ConfigurationProperties("jwt")
public class JwtConfiguration {
    String pub;
    String key;

    public RSAPublicKey getPublicKey() throws IOException {
        return RsaKeyConverters.x509().convert(loadClassPathResource(this.pub));
    }

    public RSAPrivateKey getPrivateKey() throws IOException {
        return RsaKeyConverters.pkcs8().convert(loadClassPathResource(this.key));
    }

    private InputStream loadClassPathResource(String path) throws IOException {
        return new ClassPathResource(path).getInputStream();
    }
}
