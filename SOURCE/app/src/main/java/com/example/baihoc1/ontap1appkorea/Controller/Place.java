package com.example.baihoc1.ontap1appkorea.Controller;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.baihoc1.ontap1appkorea.Controller.Adapter.PlaceAdapter;
import com.example.baihoc1.ontap1appkorea.R;
import com.example.baihoc1.ontap1appkorea.interfaces.OnClickSccues;
import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Place extends AppCompatActivity {
    RecyclerView rvTaxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_layout);
        init();
        getdata();

    }

    private void getdata() {
        GetListPlacebody getListPlacebody = new GetListPlacebody(0,0,"");
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(Api.class).getContact(getListPlacebody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
               // Toast.makeText(Place.this, "ok", Toast.LENGTH_SHORT).show();
                String strJson = null;
                try {
                    strJson = response.body().string();
                    Gson gson = new Gson();
                    com.example.baihoc1.ontap1appkorea.Model.Place place = gson.fromJson
                            (strJson, com.example.baihoc1.ontap1appkorea.Model.Place.class);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager
                            (Place.this, LinearLayoutManager.VERTICAL, false);
                    rvTaxi.setLayoutManager(linearLayoutManager);
                    PlaceAdapter adapter = new PlaceAdapter();
                    adapter.setContext(Place.this);
                    adapter.setData(place.getPlaceResults());
                    rvTaxi.setAdapter(adapter);
                    rvTaxi.addItemDecoration(new DividerItemDecoration
                            (Place.this, DividerItemDecoration.VERTICAL));


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Place.this, "that bai"+t, Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void init() {
        rvTaxi = findViewById(R.id.rv_sdt_taxi);
    }

    public class GetListPlacebody {
        int cateID, placeID;
        String searchKey;

        public GetListPlacebody(int cateID, int placeID, String searchKey) {
            this.cateID = cateID;
            this.placeID = placeID;
            this.searchKey = searchKey;
        }
    }
}
