package com.example.elitereader.network;

import com.example.elitereader.Constant.API_CONST;
import com.example.elitereader.Models.NovelList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("API_call_all.php")
    Call<NovelList> getMyJSON();
}
