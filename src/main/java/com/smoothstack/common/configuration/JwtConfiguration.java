package com.smoothstack.common.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.converter.RsaKeyConverters;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

    private ByteArrayInputStream loadClassPathResource(String path) throws IOException {
        File file = new ClassPathResource(path).getFile();
        return new ByteArrayInputStream(Files.readAllBytes(file.toPath()));
    }
}
