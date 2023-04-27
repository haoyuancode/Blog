package com.mason.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mason.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * 分类表(Category)表数据库访问层
 *
 * @author mason
 * @since 2023-04-23 22:05:38
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
