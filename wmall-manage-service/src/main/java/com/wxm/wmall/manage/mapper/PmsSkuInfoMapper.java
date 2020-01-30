package com.wxm.wmall.manage.mapper;

import com.wxm.wmall.bean.PmsSkuInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-27 17:01
 */
public interface PmsSkuInfoMapper extends Mapper<PmsSkuInfo>{
    List<PmsSkuInfo> selectSkuSaleAttrValueListBySpu(String productId);
}
