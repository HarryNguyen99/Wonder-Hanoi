package com.example.baihoc1.ontap1appkorea.Controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baihoc1.ontap1appkorea.Controller.Adapter.PromotionAdapter;
import com.example.baihoc1.ontap1appkorea.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class PromotionFragment extends Fragment {
    RecyclerView rvKhachSan;
    View vRoot;


    public PromotionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vRoot = inflater.inflate(R.layout.fragment_promotion, container, false);
        init();
        getdata();
        return vRoot;
    }

    private void init() {
        rvKhachSan = vRoot.findViewById(R.id.rv_khach_san);

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
                                    new LinearLayoutManager(getContext(),
                                            LinearLayoutManager.VERTICAL,false);
                            rvKhachSan.setLayoutManager(linearLayoutManager);
                            PromotionAdapter adapter = new PromotionAdapter();
                            adapter.setContext(getContext());
                            adapter.setData(promotion.getResult());
                            rvKhachSan.setAdapter(adapter);
                            rvKhachSan.addItemDecoration
                                    (new DividerItemDecoration
                                            (getContext(), DividerItemDecoration.VERTICAL));

                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

    }

}
