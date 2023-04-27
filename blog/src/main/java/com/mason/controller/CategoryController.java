package com.mason.controller;

import com.mason.domain.ResponseResult;
import com.mason.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 22102
 * @version 1.0
 * @description: TODO
 * @date 2023/4/23 22:09
 */
@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("getCategoryList")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }

}
