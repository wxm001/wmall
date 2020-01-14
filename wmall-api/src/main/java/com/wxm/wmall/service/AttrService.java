package com.wxm.wmall.service;

import com.wxm.wmall.bean.PmsBaseAttrInfo;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-14 16:03
 */
public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);
}
