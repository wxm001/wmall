package com.wxm.wmall.service;

import com.wxm.wmall.bean.PmsProductImage;
import com.wxm.wmall.bean.PmsProductInfo;
import com.wxm.wmall.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-19 17:08
 */

public interface SpuService {

    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);

    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId, String id);
}
