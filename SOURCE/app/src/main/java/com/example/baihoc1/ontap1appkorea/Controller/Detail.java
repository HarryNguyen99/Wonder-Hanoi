package com.example.baihoc1.ontap1appkorea.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baihoc1.ontap1appkorea.Controller.Adapter.DetailAdapter;
import com.example.baihoc1.ontap1appkorea.Model.Place;
import com.example.baihoc1.ontap1appkorea.Model.PlaceResult;
import com.example.baihoc1.ontap1appkorea.R;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detail extends AppCompatActivity {

    ArrayList<Object> data = new ArrayList<>();
    RecyclerView rvPlaceDetail;
    DetailAdapter adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_place_layoutt);
        init();
        configRV();
        getData();
        setToolBar();
    }

    private void setToolBar() {
        toolbar = findViewById(R.id.tb_tieu_de);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    private void getData() {
        PlaceResult placeResult = (PlaceResult)getIntent().getSerializableExtra("promotion");
        data.add(placeResult);
       // Log.d("", "getData: ");
        for(int i = 0; i< placeResult.getListMedia().size();i++){
            data.add(placeResult.getListMedia().get(i));
        }


    }

    private void configRV() {

        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvPlaceDetail.setLayoutManager(linearLayoutManager);
        adapter =new DetailAdapter(data,this);
        rvPlaceDetail.setAdapter(adapter);

    }

    private void init() {
        rvPlaceDetail = findViewById(R.id.rv_place_detail);

    }

}
