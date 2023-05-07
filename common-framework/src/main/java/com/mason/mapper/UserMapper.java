package com.mason.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(User)表数据库访问层
 *
 * @author mason
 * @since 2023-05-07 17:02:43
 */
@Mapper
public interface UserMapper extends BaseMapper<entity.User> {

}
