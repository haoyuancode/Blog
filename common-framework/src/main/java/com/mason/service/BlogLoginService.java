package com.mason.service;

import com.mason.domain.ResponseResult;

/**
 * @author 22102
 * @version 1.0
 * @description: TODO
 * @date 2023/5/15 20:13
 */
public interface BlogLoginService {

    ResponseResult login(entity.User user);

}
