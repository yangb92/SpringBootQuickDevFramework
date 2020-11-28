package com.yangb.project.quickdev;

import com.yangb.project.quickdev.config.comment.JwtUtil;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.Key;

/**
 * com.yangb.project.quickdev
 * Create by YangBin on 2020/11/28
 * Copyright © 2020 YangBin. All rights reserved.
 */
public class JwtTests {

    @Test
    void encode() {
        // We need a signing key, so we'll create one just for this example. Usually
// the key would be read from your application configuration instead.
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String secretString = Encoders.BASE64.encode(key.getEncoded());

        System.out.println(secretString);

        String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();

        System.out.println(jws);

        String subject = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws).getBody().getSubject();

        System.out.println(subject);
    }

    String info = "Hello World";

    @Test
    void encodeOne(){
        System.out.println("加密方式一：自动生成密钥，密钥不对外暴露，除了此程序能解密之外，开发人员也不能解密");
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jws = Jwts.builder().setSubject(info).signWith(key).compact();
        System.out.println(jws);
        String subject = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws).getBody().getSubject();
        System.out.println(subject);
    }

    @Test
    void encodeTwo(){
        System.out.println("加密方式二：手动指定密钥");
        Key key = Keys.hmacShaKeyFor("uiquwieoqruiolhqhoiqhweqjeoj123jowei".getBytes(StandardCharsets.UTF_8));
        String jws = Jwts.builder().setSubject(info).signWith(key).compact();
        System.out.println("JWT加密:" + jws);
        String subject = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws).getBody().getSubject();
        System.out.println("JWT解密" + subject);
    }

    @Test
    void testJu(){
        String ed = JwtUtil.encoder("{user:123}");
        String content = JwtUtil.decoder(ed);
        System.out.println(content);
    }
}
