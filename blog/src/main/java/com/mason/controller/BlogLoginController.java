package com.mason.controller;

import com.mason.domain.ResponseResult;
import com.mason.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 22102
 * @version 1.0
 * @description: TODO
 * @date 2023/5/15 20:09
 */
@RestController
public class BlogLoginController {

    @Autowired
    private BlogLoginService blogLoginService;

    @PostMapping("login")
    public ResponseResult login(@RequestBody entity.User user){
        return blogLoginService.login(user);
    }

}
