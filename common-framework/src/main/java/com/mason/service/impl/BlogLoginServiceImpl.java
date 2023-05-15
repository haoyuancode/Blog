package com.mason.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mason.config.JwtUtil;
import com.mason.config.RedisCache;
import com.mason.domain.ResponseResult;
import com.mason.entity.Article;
import com.mason.entity.LoginUser;
import com.mason.mapper.ArticleMapper;
import com.mason.service.ArticleService;
import com.mason.service.BlogLoginService;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author 22102
 * @version 1.0
 * @description: TODO
 * @date 2023/5/15 20:14
 */
@Service
public class BlogLoginServiceImpl implements BlogLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断是否认证通过
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userId，生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //把用户信息存入redis
        redisCache.setCacheObject("bloglogin"+userId,loginUser);
        //把token和userInfo封装 返回
        return null;
    }
}
