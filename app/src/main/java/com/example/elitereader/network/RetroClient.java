package com.example.elitereader.network;

import com.example.elitereader.Constant.API_CONST;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.elitereader.Constant.API_CONST.API_URL;

public class RetroClient {
    private static final String url = API_URL;

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }

}
