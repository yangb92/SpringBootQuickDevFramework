package com.yangb.project.quickdev.config.comment;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
/**
 * com.yangb.project.quickdev.config.comment
 * Create by YangBin on 2020/11/28
 * Copyright © 2020 YangBin. All rights reserved.
 */
public class JwtUtil {

    private final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String encoder(String val){
        String token = Jwts.builder().setSubject(val).signWith(key).compact();
        return token;
    }

    public static String decoder(String token){
        System.out.println(token);
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }
}
