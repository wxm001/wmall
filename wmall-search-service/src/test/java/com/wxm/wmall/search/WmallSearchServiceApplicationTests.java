package com.wxm.wmall.search;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxm.wmall.bean.PmsSearchSkuInfo;
import com.wxm.wmall.bean.PmsSkuInfo;
import com.wxm.wmall.service.SkuService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WmallSearchServiceApplicationTests {

	@Reference
	SkuService skuService;

	@Autowired
	JestClient jestClient;


	@Test
	public void contextLoads() throws IOException {

//		//用api实现复杂查询
//		List<PmsSearchSkuInfo> pmsSearchSkuInfos = new ArrayList<>();
//		Search search = new Search.Builder("{\n" +
//				"  \"query\": {\n" +
//				"    \"bool\": {\n" +
//				"      \"filter\": [{\n" +
//				"        \"term\": {\n" +
//				"          \"skuAttrValueList.valueId\": \"88\"\n" +
//				"        }\n" +
//				"      },\n" +
//				"      {\n" +
//				"        \"term\": {\n" +
//				"          \"skuAttrValueList.valueId\": \"52\"\n" +
//				"        }\n" +
//				"      }\n" +
//				"      ]\n" +
//				"      ,\"must\": [\n" +
//				"        {\n" +
//				"          \"match\": {\n" +
//				"            \"skuName\": \"华为\"\n" +
//				"          }\n" +
//				"        }\n" +
//				"      ]\n" +
//				"    }\n" +
//				"  }\n" +
//				"}").addIndex("wmall").addType("PmsSkuInfo").build();
//
//		SearchResult execute = jestClient.execute(search);
//
//		List<SearchResult.Hit<PmsSearchSkuInfo, Void>> hits = execute.getHits(PmsSearchSkuInfo.class);
//
//		for (SearchResult.Hit<PmsSearchSkuInfo, Void> hit : hits) {
//			PmsSearchSkuInfo source = hit.source;
//			pmsSearchSkuInfos.add(source);
//		}
//		System.out.println(pmsSearchSkuInfos);
		put();
	}

	public void put() throws IOException {
		//查询mysql数据
		List<PmsSkuInfo> pmsSkuInfoList = new ArrayList<>();
		pmsSkuInfoList = skuService.getAllSku("61");
		//转换为es的数据结构
		List<PmsSearchSkuInfo> pmsSearchSkuInfos = new ArrayList<>();

		for (PmsSkuInfo pmsSkuInfo : pmsSkuInfoList) {
			PmsSearchSkuInfo pmsSearchSkuInfo =new PmsSearchSkuInfo();

			BeanUtils.copyProperties(pmsSkuInfo,pmsSearchSkuInfo);
			pmsSearchSkuInfo.setId(Long.parseLong(pmsSkuInfo.getId()));

			pmsSearchSkuInfos.add(pmsSearchSkuInfo);

		}

		//导入ES
		for (PmsSearchSkuInfo pmsSearchSkuInfo : pmsSearchSkuInfos) {
			Index put = new Index.Builder(pmsSearchSkuInfo).index("wmall").type("PmsSkuInfo").id(pmsSearchSkuInfo.getId()+"").build();
			jestClient.execute(put);
		}
	}

}
