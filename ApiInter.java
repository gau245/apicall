package com.example.gautam_news_app.Api;

import com.example.gautam_news_app.Model.ModelNews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInter {

    @GET("everything?q=apple&from=2022-02-26&to=2022-02-26&sortBy=popularity&apiKey=ff1c5bf18d6a445e8dce383df54c2c38")
    Call<ModelNews> getData();

}
