package com.wxm.wmall.service;

import com.wxm.wmall.bean.PmsSearchParam;
import com.wxm.wmall.bean.PmsSearchSkuInfo;

import java.util.List;

/**
 * @author wxm
 * @create 2020-02-05 19:36
 */
public interface SearchService {


    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
