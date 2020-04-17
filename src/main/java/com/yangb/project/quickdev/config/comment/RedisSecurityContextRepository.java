package com.yangb.project.quickdev.config.comment;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author Created by yangb on 2020/4/17
 */
@Component
public class RedisSecurityContextRepository implements SecurityContextRepository {

    @Resource
    private RedisTemplate<String, SecurityContext> securityContextRedisTemplate;

    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        String requestedSessionId = requestResponseHolder.getRequest().getRequestedSessionId();
        return securityContextRedisTemplate.opsForValue().get(requestedSessionId);
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        String requestedSessionId = request.getRequestedSessionId();
        securityContextRedisTemplate.opsForValue().set(requestedSessionId,context,30, TimeUnit.MINUTES);
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        return securityContextRedisTemplate.hasKey(request.getRequestedSessionId());
    }

    /**
     * 清除Redis上下文
     * @param request
     * @return
     */
    public boolean cleanContext(HttpServletRequest request){
        return securityContextRedisTemplate.delete(request.getRequestedSessionId());
    }
}
