package com.wxm.wmall.service;

import com.wxm.wmall.bean.PmsSkuInfo; /**
 * @author wxm
 * @create 2020-01-27 16:56
 */
public interface SkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuById(String skuId);
}
