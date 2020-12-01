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
        return Jwts.builder().setSubject(val).signWith(key).compact();
    }

    public static String decoder(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }
}
