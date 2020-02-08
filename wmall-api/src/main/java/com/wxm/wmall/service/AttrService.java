package com.wxm.wmall.service;

import com.wxm.wmall.bean.PmsBaseAttrInfo;
import com.wxm.wmall.bean.PmsBaseAttrValue;
import com.wxm.wmall.bean.PmsBaseSaleAttr;

import java.util.List;
import java.util.Set;

/**
 * @author wxm
 * @create 2020-01-14 16:03
 */
public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();

    List<PmsBaseAttrInfo> getAttrValueListByValueId(Set<String> valueSet);
}
