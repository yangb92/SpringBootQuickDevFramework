package com.yangb.project.quickdev.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yangb.project.quickdev.entity.AppUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;

import java.nio.charset.Charset;

/**
 * Created by yangb on 2020/4/17
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, SecurityContext> securityContextRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        template.setValueSerializer(new SecurityContextSerializer());
        return template;
    }

    /**
     * SecurityContext 序列化
     */
    private class SecurityContextSerializer implements RedisSerializer<SecurityContext>{

        @Override
        public byte[] serialize(SecurityContext securityContext) throws SerializationException {
            if (securityContext == null) {
                return null;
            }
            String s = JSON.toJSONString(securityContext);
            return s.getBytes(Charset.forName("UTF-8"));
        }

        @Override
        public SecurityContext deserialize(byte[] bytes) throws SerializationException {
            SecurityContextImpl securityContext = new SecurityContextImpl();
            if (bytes == null) {
                return securityContext;
            }
            String json = new String(bytes, Charset.forName("UTF-8"));
            final JSONObject jb = JSON.parseObject(json);
            JSONObject authentication = jb.getJSONObject("authentication");
            if(authentication == null) {
                return securityContext;
            }
            AppUser user = authentication.getObject("principal", AppUser.class);
            JSONArray authorities = authentication.getJSONArray("authorities");
            String [] authoritiesArray = new String[authorities.size()];
            for (int i = 0; i < authorities.size(); i++) {
                JSONObject authority = authorities.getJSONObject(i);
                authoritiesArray[i] = authority.getString("authority");
            }
            securityContext.setAuthentication(new UsernamePasswordAuthenticationToken(user, null, AuthorityUtils.createAuthorityList(authoritiesArray)));
            return securityContext;
        }
    }
}
