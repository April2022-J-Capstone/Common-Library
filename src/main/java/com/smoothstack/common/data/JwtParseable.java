package com.smoothstack.common.data;

import com.smoothstack.common.exceptions.TokenInvalidException;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;

// Represents a data type that can be converted to/from Jwt format.
public interface JwtParseable<T> {
    public T decode(JwtDecoder decoder, String jwt) throws TokenInvalidException;
    public String encode(JwtEncoder encoder);
}
