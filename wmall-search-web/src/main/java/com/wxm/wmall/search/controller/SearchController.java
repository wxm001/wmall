package com.wxm.wmall.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxm.wmall.bean.PmsSearchParam;
import com.wxm.wmall.bean.PmsSearchSkuInfo;
import com.wxm.wmall.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wxm
 * @create 2020-02-05 18:48
 */
@Controller
public class SearchController {

    @Reference
    SearchService searchService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("list.html")
    public String list(PmsSearchParam pmsSearchParam, ModelMap modelMap){

        //调用搜索服务，返回搜索结果
        List<PmsSearchSkuInfo> pmsSearchSkuInfos = searchService.list(pmsSearchParam);
        modelMap.put("skuLsInfoList",pmsSearchSkuInfos);
        return "list";
    }
}
