package com.myaipe.Demo01;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @description: 用jdk11
 * @Author: wangchao
 * @Date: 2021/2/7
 */
public class postTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        List<String> groupIds = new ArrayList<>(Arrays.asList("10907434497470827465", "10907434497470944232", "10907434497471612617", "10907434497471616790", "10907434497471621458", "10907434497471720596", "10907434497471739205", "10907434497471838271", "10907434497471928348", "10907434497472100548", "10907434497472610249", "10907434497472658744", "10907434497473169466", "10907434497473274496", "10907434497474416824", "10907434497474423324", "10907434497476026365", "10907434497476951122", "10907434497476968630", "10907434497477465484", "10907434497477512526", "10907434497477684700", "10907434497477818588", "10907434497477943769", "10907434497481219685", "10907434497481536083", "10907434497482852622", "10907434497483501637", "10907434497483538328", "10907434497483997255", "10907434497484017942", "10907434497485984091", "10907434497486755937", "10907434497486765974", "10907434497486902152", "10907434497487115755", "10907434497487135000", "10907434497487240703", "10907434497487439321", "10907434497487995494", "10907434497487999628", "10907434497489300268", "10907434497489594973", "10907434497491177632", "10907434497491180216", "10907434497491223015", "10907434497491225663", "10907434497491229262", "10907434497491231984", "10907434497491235156", "10907434497491295834", "10907434497491391026", "10907434497492014303", "10907434497492354864", "10907434497492718889", "10907434497492756236", "10907434497493068900", "10907434497493411338", "10907434497493658722", "10907434497493664309", "10907434497493701761", "10907434497493889848", "10907434497494000767", "10907434497494174925", "10907434497494498118", "10907434497494500595", "10907434497495512236", "10907434497496430879", "10907434497496441257", "10907434497496444128", "11240984669916771517", "11240984669916771022", "11240984669916781516", "11240984669916786516", "11240984669916788016", "11240984669916787018", "11240984669916787019", "11240984669916791516"));
        int partitionSize = 4;
        int minute = 15;
        List<List<String>> partition = Lists.partition(groupIds, partitionSize);
        for (List<String> list : partition) {
            // 15 minute
            execPost(list);
            LocalDateTime now = LocalDateTime.now();
            String tome = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println(tome + " -执行完:" + JSON.toJSONString(list));
            Thread.sleep(1000 * 60 * minute);
        }
    }

    public static void execPost(List<String> groupIds) throws IOException, InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.of(2021, 2, 11, 5, 30, 0);
        if (now.isAfter(endTime)) {
            throw new RuntimeException("超出执行时间" + now);
        }

        if (Objects.isNull(groupIds) || groupIds.size() == 0) {
            throw new RuntimeException("入参为空");
        }
        String cookid = "XXL_JOB_LOGIN_IDENTITY=6232383763663565356636333933653466303733626238346634633464306163; _yg_test=d8SAkqDZ-kc3BUS5WDsAzB_WN8v5AxnTR7ATZQK7zzZzox3yy3Cx_N66FS3M4Nujsz9xsNLVAqVeOM120q6NvOSEcvckF4e3RG2R_jh48gJ54159bNDvoKwhCHZVuk0b-jB91lHyS7Sd656FUeWSKNyqU_6NWrIixXE.";
        String param = "{\"operationType\":\"pullFullPartInfo\",\"idOwnOrgs\"" + ":" + JSON.toJSONString(groupIds) + "}";
        String url = "http://xxljob.f6yc.com/xxl-job-admin/jobinfo/trigger?id=254&executorParam=" + URLEncoder.encode(param, "utf-8");
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest.BodyPublisher requestBody = HttpRequest.BodyPublishers.ofString("");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(requestBody)
                .uri(URI.create(url))
                .header("Cookie", cookid)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
