package com.wxm.wmall.service;

import com.wxm.wmall.bean.PmsSkuInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wxm
 * @create 2020-01-27 16:56
 */
public interface SkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuById(String skuId,String ip);

    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);

    List<PmsSkuInfo> getAllSku(String catalog3Id);

    boolean checkPrice(String productSkuId, BigDecimal price);
}
