package com.wxm.wmall.manage.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.wxm.wmall.bean.PmsSkuInfo;
import com.wxm.wmall.service.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wxm
 * @create 2020-01-27 16:49
 */

@Controller
@CrossOrigin
public class skuController {

    @Reference
    SkuService skuService;

    @RequestMapping("saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo){
        //将spuId封装给productId
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
        //处理默认图片
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
        if(StringUtils.isBlank(skuDefaultImg)){
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }

        skuService.saveSkuInfo(pmsSkuInfo);
        return "success";
    }
}
