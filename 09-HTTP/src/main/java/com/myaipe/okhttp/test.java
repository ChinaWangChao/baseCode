package com.myaipe.okhttp;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;


/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/15
 */
@Slf4j
public class test {
    public static void main(String[] args) {
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        OkHttpClient okHttpClient = new OkHttpClient();
        String requestBody ="";
        Request request = new Request.Builder()
                .url("")
                .post(RequestBody.create(requestBody,mediaType))
                .header("Cookie","")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
                System.out.println(response.message());
            }
        });
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });

    }
}
