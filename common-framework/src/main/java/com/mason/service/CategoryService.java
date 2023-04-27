package com.mason.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mason.domain.ResponseResult;
import com.mason.entity.Category;

/**
 * 分类表(Category)表服务接口
 *
 * @author mason
 * @since 2023-04-23 22:05:37
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}
