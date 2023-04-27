package com.mason.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 22102
 * @version 1.0
 * @description: TODO
 * @date 2023/4/27 15:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
    private List rows;
    private Long total;
}
