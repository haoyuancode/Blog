package com.mason.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mason.domain.ResponseResult;
import com.mason.entity.Article;
import com.mason.service.ArticleService;
import com.mason.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章表(Article)表服务实现类
 *
 * @author makejava
 * @since 2023-03-08 21:48:09
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    //查询热门文章
    @Override
    public ResponseResult<Article> hotArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        // 必须是正式文章（没有被逻辑删除）
        queryWrapper.eq(Article::getStatus,0);
        //根据浏览量排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多查询10条记录
        Page<Article> page = new Page<>(1,10);
        page(page, queryWrapper);

        List<Article> articles = page.getRecords();
        return ResponseResult.okResult(articles);
    }
}

