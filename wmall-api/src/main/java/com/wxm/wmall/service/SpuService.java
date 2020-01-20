package com.wxm.wmall.service;

import com.wxm.wmall.bean.PmsProductInfo;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-19 17:08
 */

public interface SpuService {

    List<PmsProductInfo> spuList(String catalog3Id);
}
