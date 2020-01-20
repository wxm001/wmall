package com.wxm.wmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wxm.wmall.bean.PmsProductInfo;
import com.wxm.wmall.manage.mapper.PmsProductInfoMapper;
import com.wxm.wmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-19 17:10
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }
}
