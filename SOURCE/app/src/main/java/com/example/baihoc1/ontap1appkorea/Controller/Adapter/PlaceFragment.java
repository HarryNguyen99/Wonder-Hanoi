package com.example.baihoc1.ontap1appkorea.Controller.Adapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baihoc1.ontap1appkorea.Controller.Api;
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
public class PlaceFragment extends Fragment {
    RecyclerView rvTaxi;
    View vRoot;


    public PlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vRoot = inflater.inflate(R.layout.fragment_place, container, false);
        init();
        getdata();
        return vRoot;
    }

    private void getdata() {
        GetListPlacebody getListPlacebody = new GetListPlacebody(0, 0, "");
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(Api.class).getContact(getListPlacebody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String strJson = null;
                try {
                    strJson = response.body().string();
                    Gson gson = new Gson();
                    com.example.baihoc1.ontap1appkorea.Model.Place place = gson.fromJson
                            (strJson, com.example.baihoc1.ontap1appkorea.Model.Place.class);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager
                            (getContext(), LinearLayoutManager.VERTICAL, false);
                    rvTaxi.setLayoutManager(linearLayoutManager);
                    PlaceAdapter adapter = new PlaceAdapter();
                    adapter.setContext(getContext());
                    adapter.setData(place.getPlaceResults());
                    rvTaxi.setAdapter(adapter);
                    rvTaxi.addItemDecoration(new DividerItemDecoration
                            (getContext(), DividerItemDecoration.VERTICAL));


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


    private void init() {
        {
            rvTaxi = vRoot.findViewById(R.id.rv_sdt_taxi);
        }
    }

    class GetListPlacebody {
        int cateID, placeID;
        String searchKey;

        public GetListPlacebody(int cateID, int placeID, String searchKey) {
            this.cateID = cateID;
            this.placeID = placeID;
            this.searchKey = searchKey;
        }


    }
}
