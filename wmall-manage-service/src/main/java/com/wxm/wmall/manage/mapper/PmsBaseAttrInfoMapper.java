package com.wxm.wmall.manage.mapper;

import com.wxm.wmall.bean.PmsBaseAttrInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-14 16:10
 */
public interface PmsBaseAttrInfoMapper extends Mapper<PmsBaseAttrInfo>{
    List<PmsBaseAttrInfo> selectAttrValueListByValueId(@Param("valueIdStr") String valueIdStr);
}
