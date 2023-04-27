package com.mason.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 22102
 * @version 1.0
 * @description: TODO
 * @date 2023/4/23 20:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotArticleVo {

    private Long id;
    //标题
    private String title;
    //访问量
    private Long viewCount;
}
