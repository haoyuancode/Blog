package com.mason.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mason.entity.Article;
import com.mason.service.ArticleService;
import com.mason.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
 * 文章表(Article)表服务实现类
 *
 * @author makejava
 * @since 2023-03-08 21:48:09
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}

