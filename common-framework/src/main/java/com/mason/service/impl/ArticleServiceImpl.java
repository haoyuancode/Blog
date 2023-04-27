package com.mason.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mason.constants.SystemConstants;
import com.mason.domain.ResponseResult;
import com.mason.domain.vo.ArticleListVo;
import com.mason.domain.vo.HotArticleVo;
import com.mason.domain.vo.PageVo;
import com.mason.entity.Article;
import com.mason.entity.Category;
import com.mason.service.ArticleService;
import com.mason.mapper.ArticleMapper;
import com.mason.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 文章表(Article)表服务实现类
 *
 * @author makejava
 * @since 2023-03-08 21:48:09
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private CategoryService categoryService;

    //查询热门文章
    @Override
    public ResponseResult<Article> hotArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        // 必须是正式文章（没有被逻辑删除）
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //根据浏览量排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多查询10条记录
        Page<Article> page = new Page<>(1,10);
        page(page, queryWrapper);

        List<Article> articles = page.getRecords();
        //bean拷贝
        List<HotArticleVo> hotArticleVos = new ArrayList<>();
        for(Article article:articles){
            HotArticleVo hotArticleVo = new HotArticleVo();
            BeanUtils.copyProperties(article,hotArticleVo);
            hotArticleVos.add(hotArticleVo);
        }
        return ResponseResult.okResult(hotArticleVos);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long cateGoryId) {

        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //根据分类id判断
        queryWrapper.eq(Objects.nonNull(cateGoryId)&&cateGoryId>0,Article::getCategoryId,cateGoryId);
        //状态是已发布
        queryWrapper.eq(Article::getStatus,SystemConstants.ARTICLE_STATUS_NORMAL);
        //对istop进行降序(是否置顶)
        queryWrapper.orderByDesc(Article::getIsTop);
        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);

        List<Article> articles = page.getRecords();

        //封装VO
        List<ArticleListVo> articleListVos = new ArrayList<>();

        for (Article article: articles){
            ArticleListVo articleListVo = new ArticleListVo();

            //根据articlez中的分类id查询分类表中的分类名并设置给文章表
            Category category = categoryService.getById(article.getCategoryId());
            article.setCategoryName(category.getName());

            BeanUtils.copyProperties(article,articleListVo);
            articleListVos.add(articleListVo);
        }

        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }
}

