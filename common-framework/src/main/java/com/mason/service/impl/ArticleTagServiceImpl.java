package com.mason.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mason.mapper.ArticleTagMapper;
import com.mason.entity.ArticleTag;
import com.mason.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * 文章标签关联表(ArticleTag)表服务实现类
 *
 * @author mason
 * @since 2023-03-08 23:06:35
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

}

