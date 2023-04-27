package com.mason.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 22102
 * @version 1.0
 * @description: TODO
 * @date 2023/4/27 14:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo {

    private Long id;

    //分类名
    private String name;
}
