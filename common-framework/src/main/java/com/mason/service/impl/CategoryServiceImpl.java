package com.mason.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mason.constants.SystemConstants;
import com.mason.domain.ResponseResult;
import com.mason.domain.vo.CategoryVo;
import com.mason.entity.Article;
import com.mason.entity.Category;
import com.mason.mapper.CategoryMapper;
import com.mason.service.ArticleService;
import com.mason.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author mason
 * @since 2023-04-23 22:05:37
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {
        //查询文章表中已发布的文章的分类id，并去重
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articleWrapper);

        Set<Long> categoryIds = articleList.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());

        //根据文章表查出来的去重之后的分类id去查询分类表,并且分类表中的状态是正常
        List<Category> categories = listByIds(categoryIds);

        categories = categories.stream()
                .filter(category -> {
                    return SystemConstants.STATUS_NORMAL.equals(category.getStatus());
                })
                .collect(Collectors.toList());

        //封装VO
        List<CategoryVo> categoryVos = new ArrayList<>();
        for (Category category:categories){
            CategoryVo categoryVo = new CategoryVo();
            BeanUtils.copyProperties(category,categoryVo);
            categoryVos.add(categoryVo);
        }

        return ResponseResult.okResult(categoryVos);
    }
}
