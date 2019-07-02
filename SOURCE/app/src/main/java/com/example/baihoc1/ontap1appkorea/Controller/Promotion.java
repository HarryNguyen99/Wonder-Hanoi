package com.example.baihoc1.ontap1appkorea.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.baihoc1.ontap1appkorea.Controller.Adapter.PromotionAdapter;
import com.example.baihoc1.ontap1appkorea.Model.PlaceResult;
import com.example.baihoc1.ontap1appkorea.R;
import com.example.baihoc1.ontap1appkorea.Util.UtilDocJson;
import com.example.baihoc1.ontap1appkorea.interfaces.OnClickSccues;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Promotion extends AppCompatActivity {

    ArrayList<Promotion> data = new ArrayList<>();
    RecyclerView rvKhachSan;
    PromotionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promotion_layout);

        init();
        getdata();

    }

    private void getdata() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://150.95.115.192/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(Api.class).getPromotion(new Object())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String strJson = null;
                        try {
                            strJson = response.body().string();
                            Gson gson = new Gson();
                            com.example.baihoc1.ontap1appkorea.Model.Promotion promotion = gson.fromJson
                                    (strJson, com.example.baihoc1.ontap1appkorea.Model.Promotion.class);
                            LinearLayoutManager linearLayoutManager =
                                    new LinearLayoutManager(Promotion.this,
                                            LinearLayoutManager.VERTICAL,false);
                            rvKhachSan.setLayoutManager(linearLayoutManager);
                            PromotionAdapter adapter = new PromotionAdapter();
                            adapter.setContext(Promotion.this);
                            adapter.setData(promotion.getResult());
                            rvKhachSan.setAdapter(adapter);
                            rvKhachSan.addItemDecoration
                                    (new DividerItemDecoration
                                            (Promotion.this, DividerItemDecoration.VERTICAL));

                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }


    private void init() {

        rvKhachSan = findViewById(R.id.rv_khach_san);


    }
}
