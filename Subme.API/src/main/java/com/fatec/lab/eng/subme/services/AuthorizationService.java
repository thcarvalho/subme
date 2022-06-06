package com.fatec.lab.eng.subme.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthorizationService {
    public Long GetIdFromJWT(String token) {
        try {
            String newToken = token.replace("Bearer ", "");
            Algorithm algorithmHS = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithmHS)
                    .build();
            DecodedJWT jwt = verifier.verify(newToken);
            Map<String, Claim> claims = jwt.getClaims();
            Long id = claims.get("companyId").asLong();
            return id;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
}