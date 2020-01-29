package com.wxm.wmall.manage.mapper;

import com.wxm.wmall.bean.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-21 20:06
 */
public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr>{
    List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(@Param("productId") String productId, @Param("skuId") String skuId);
}
