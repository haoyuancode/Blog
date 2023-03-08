package com.mason.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章标签关联表(ArticleTag)表实体类
 *
 * @author mason
 * @since 2023-03-08 23:06:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTag {
    //文章id
    private Long articleId;
    //标签id
    private Long tagId;


}

