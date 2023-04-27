package com.mason.controller;

import com.mason.domain.ResponseResult;
import com.mason.entity.Article;
import com.mason.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 22102
 * @version 1.0
 * @description: TODO
 * @date 2023/3/8 20:55
 */
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public List<Article> test(){
        return articleService.list();
    }

    //热门文章
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        ResponseResult result = articleService.hotArticleList();
        return  result;
    }

    //文章列表(前端首页以及分类列表都要用，根据分类id判断是首页还是分类列表)
    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum,Integer pageSize, Long cateGoryId){
        return articleService.articleList(pageNum,pageSize,cateGoryId);
    }

}
