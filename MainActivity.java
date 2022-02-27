package com.example.gautam_news_app;

import static com.example.gautam_news_app.Api.ApiClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gautam_news_app.Api.ApiClient;
import com.example.gautam_news_app.Api.ApiInter;
import com.example.gautam_news_app.Model.ModelNews;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    List<ModelNews> l1 = new ArrayList<ModelNews>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiCalling();
            }
        });
    }

    void ApiCalling() {
        ApiInter apiInter = getRetrofit().create(ApiInter.class);
        apiInter.getData().enqueue(new Callback<ModelNews>() {
            @Override
            public void onResponse(Call<ModelNews> call, Response<ModelNews> response) {
                Toast.makeText(MainActivity.this, "" + response.body(), Toast.LENGTH_SHORT).show();
                Log.e("TAG", "onResponse: " + response.body());
                ModelNews modelNews = response.body();
                Log.e("TAG", "onResponse: " + modelNews.getArticles().get(0).getUrl());
                Log.e("TAG", "onResponse: " + modelNews.getArticles().get(0).getTitle());
                Log.e("TAG", "onResponse: " + modelNews.getArticles().get(0).getDescription());

            }

            @Override
            public void onFailure(Call<ModelNews> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }
}