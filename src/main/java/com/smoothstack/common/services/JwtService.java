package com.smoothstack.common.services;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import com.smoothstack.common.configuration.JwtConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import java.io.IOException;

@Service
@Profile("service")
public class JwtService {
    JwtEncoder encoder;
    JwtDecoder decoder;

    public JwtService(JwtConfiguration config) throws IOException {
        JWK jwk = new RSAKey
                .Builder(config.getPublicKey())
                .privateKey(config.getPrivateKey())
                .build();
        JWKSource<SecurityContext> source = new ImmutableJWKSet<>(new JWKSet(jwk));

        encoder = new NimbusJwtEncoder(source);
        decoder = NimbusJwtDecoder.withPublicKey(config.getPublicKey()).build();
    }

    public JwtEncoder getEncoder() { return encoder; }

    public JwtDecoder getDecoder() { return decoder; }
}
