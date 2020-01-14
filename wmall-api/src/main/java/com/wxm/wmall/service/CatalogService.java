package com.wxm.wmall.service;

import com.wxm.wmall.bean.PmsBaseCatalog1;
import com.wxm.wmall.bean.PmsBaseCatalog2;
import com.wxm.wmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-14 14:12
 */
public interface CatalogService {
    List<PmsBaseCatalog1> getCatalog1();


    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
