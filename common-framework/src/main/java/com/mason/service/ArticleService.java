package com.mason.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mason.domain.ResponseResult;
import com.mason.entity.Article;

/**
 * 文章表(Article)表服务接口
 *
 * @author makejava
 * @since 2023-03-08 21:48:08
 */
public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long cateGoryId);

    ResponseResult getArticleDetail(Long id);
}

