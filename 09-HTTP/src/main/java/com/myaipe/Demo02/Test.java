package com.myaipe.Demo02;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/2/24
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                50,
                50,
                //  线程池维护线程所允许的空闲时间
                3,
                // 单位
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadFactoryBuilder().setNameFormat("testThread-%d").build(),
                new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 100; i < 200; i++) {
            String brandName = "brands" + i;
//            pool.execute(() -> exec(brandName));
            exec(brandName);
        }
//        exec();
    }

    private static void exec(String brandName) {
//        String brandName = "12345600";
        String threadName = Thread.currentThread().getName();
        String checkDuplicateBrandUrl = "http://ids-goods-test.f6car.org/f6-ids-goods/brand/checkDuplicateBrand?brandName=" + brandName;
        String addTmCustomPartBrandUrl = "http://ids-goods-test.f6car.org/f6-ids-goods/brand/addTmCustomPartBrand";
//        String cookid = "f6-ids-goodsSESSIONID=49a911d3-42aa-40c7-b8aa-33b612f56b03; gr_user_id=e86d14bb-d18f-44b1-9734-717b753e83a7; grwng_uid=6460241d-8498-4b1c-b472-bf01bd8c0041; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2215446577379557047910%22%2C%22first_id%22%3A%22174d8bd0922779-0a2d3c74ae7062-31687304-1764000-174d8bd0923c12%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%22174d8bd0922779-0a2d3c74ae7062-31687304-1764000-174d8bd0923c12%22%7D; sstOrg=15447348050015594339; unsst=15447348050015629954; _sst=tgsrDjVCR7Cgkq698PmHVSXKUDKoOiIh0hmcGEXVvtEMNZ2t0FaUuNS2qRZoJ0aRacTn7qRmponuzpOd1Kf2Sni5FHd5sDNPcpsF-MFui2ECtB0nb3Xyk8BtkTmuuCeXN5oaceLM1daZ_TCy1ER4-IGJY_v32Hxzzt1LGn1ER5qGSw..; testOrg=10907434497393125695; untest=14870719207238162374; _test=KSbqIgJUIUIC_p3sYbxeAl9-zTFIrDTJ1zztWFrgQUn-5GiFkGlBvfzuCbctwxFmMW5qO3MjPgUbwzxxy073DyrA3k9bKGzGiaMNbAI2wmDIEY07iyD6_Xlj-r9VCKgMD-vMMk7ZMQ6KNxzZFcjL7Ie5ZUnQEeTuMxcl9mfyoRDOdA..";
        String cookid = "f6-ids-goodsSESSIONID=20a8ead2-429a-4cff-946b-c4fabf90821b; gr_user_id=e86d14bb-d18f-44b1-9734-717b753e83a7; grwng_uid=6460241d-8498-4b1c-b472-bf01bd8c0041; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2215446577379557047910%22%2C%22first_id%22%3A%22174d8bd0922779-0a2d3c74ae7062-31687304-1764000-174d8bd0923c12%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%22174d8bd0922779-0a2d3c74ae7062-31687304-1764000-174d8bd0923c12%22%7D; testOrg=14870518898927085522; untest=14870518898927085526; _test=KSbqIgJUIUIC_p3sYbxeAl9-zTFIrDTL1z3nUVXrQEb_6m-DlWtBvfzuCbctwxFmMW5qO3MjPgUbwzxxyU70DSvA3khdKGzGiaMNbAI2wmDIEIwxiybx8HVq-r9VCKgMD-vMMk7ZMQ6INx3THMfA7Yi4a07WFObuMxd_mwOWjWWLGA..";
        try {
            String data = execGet(checkDuplicateBrandUrl, cookid);
            System.out.println(threadName + "是否可以新建:" + data);
            HttpMSg httpMSg = JSON.parseObject(data, HttpMSg.class);
            if (httpMSg.isData()) {
                String body = "{\"partBrandName\":\"" + brandName + "\"}";
                String response = execPost(addTmCustomPartBrandUrl, cookid, body);
                System.out.println(threadName + "新建并返回" + response);
                String updateCommonBrandUrl = "http://ids-goods-test.f6car.org/f6-ids-goods/brand/updateCommonBrand?brandName=" + brandName;
                String s = execGet(updateCommonBrandUrl, cookid);
                System.out.println(threadName + "更新缓存并返回" + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String execGet(String url, String cookid) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .header("Cookie", cookid)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String execPost(String url, String cookid, String body) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest.BodyPublisher requestBody = HttpRequest.BodyPublishers.ofString(body);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(requestBody)
                .uri(URI.create(url))
                .header("Cookie", cookid)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
