package com.smoothstack.common.data;

import com.smoothstack.common.exceptions.TokenInvalidException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.jwt.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResetPasswordToken implements JwtParseable<ResetPasswordToken> {
    private Integer userId;
    private String confirmation;
    private Date expiry;

    public ResetPasswordToken decode(JwtDecoder decoder, String jwt) throws TokenInvalidException {
        try {
            Jwt token = decoder.decode(jwt);

            return ResetPasswordToken.builder()
                    .userId(Integer.parseInt(token.getSubject()))
                    .confirmation(token.getId())
                    .expiry(Date.from(token.getExpiresAt()))
                    .build();
        } catch (JwtException | NullPointerException | IllegalArgumentException e) {
            throw new TokenInvalidException();
        }
    }

    public String encode(JwtEncoder encoder) {
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(getUserId().toString())
                .id(getConfirmation())
                .expiresAt(getExpiry().toInstant())
                .build();

        JwtEncoderParameters params = JwtEncoderParameters.from(claims);
        return encoder.encode(params).getTokenValue();
    }
}
