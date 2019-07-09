package com.example.baihoc1.ontap1appkorea.Controller;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baihoc1.ontap1appkorea.Controller.Adapter.HomeAdapter;
import com.example.baihoc1.ontap1appkorea.Controller.Adapter.PromotionAdapter;
import com.example.baihoc1.ontap1appkorea.Model.Category;
import com.example.baihoc1.ontap1appkorea.Model.ContactResult;
import com.example.baihoc1.ontap1appkorea.Model.ListCate;
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
public class HomeFragment extends Fragment {
    RecyclerView rvhome;
    View vroot;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vroot = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        getdata();

        return vroot;
    }

    private void init() {
        rvhome = vroot.findViewById(R.id.rv_home);

    }

    private void getdata() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(Api.class).getCategory().
                enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String strJson = null;
                        try {
                            strJson = response.body().string();
                            Gson gson = new Gson();
                            Category category = gson.fromJson (strJson, Category.class);
                            rvhome.setLayoutManager ( new GridLayoutManager
                                    (getContext(), 4));
                            HomeAdapter adapter = new HomeAdapter();
                            adapter.setContext(getContext());
                            adapter.setData(category.getCategoryResult());
                            rvhome.setAdapter(adapter);



                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });


    }
}


