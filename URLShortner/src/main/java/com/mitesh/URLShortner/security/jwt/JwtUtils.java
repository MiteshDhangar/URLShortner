package com.mitesh.URLShortner.security.jwt;

import com.mitesh.URLShortner.service.UserDetailsImpl;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;
@Component
public class JwtUtils {
    //Authorization->Bearer <Token>
    public String getjwtFromHeader(HttpServletRequest request){
        String bearerToken =request.getHeader("Authorization");
        if(bearerToken!=null && bearerToken.startsWith("Bearer")){
            return bearerToken.substring(7);

        }
        return null;
    }//this method is helper method that will help us to extract Jwt Token

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpirationMs;


    public String generateToken(UserDetailsImpl userDetails){
        String username= userDetails.getUsername();
        //we want to have roles and username embedded into token
        String roles=userDetails.getAuthorities().stream()
                .map(authority->authority.getAuthority())
                .collect(Collectors.joining(","));
        return Jwts.builder()
                .subject(username)
                .claim("roles", roles)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(key())
                .compact();
    }
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build().parseSignedClaims(token)
                .getPayload().getSubject();
    }

    public boolean validateToken(String authToken){
        try {
            Jwts.parser().verifyWith((SecretKey) key())
                    .build().parseSignedClaims(authToken);
            return true;
        } catch (JwtException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
}
