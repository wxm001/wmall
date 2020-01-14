package com.wxm.wmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wxm.wmall.bean.PmsBaseAttrInfo;
import com.wxm.wmall.bean.PmsBaseAttrValue;
import com.wxm.wmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.wxm.wmall.manage.mapper.PmsBaseAttrValueMapper;
import com.wxm.wmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-14 16:07
 */
@Service
public class AttrServiceImpl implements AttrService{

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);

        return pmsBaseAttrInfos;
    }
}
