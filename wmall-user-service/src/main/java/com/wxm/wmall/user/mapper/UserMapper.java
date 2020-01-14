package com.wxm.wmall.user.mapper;

import com.wxm.wmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-12 11:41
 */
public interface UserMapper extends Mapper<UmsMember>{
    List<UmsMember> selectAllUser();
}
