package com.example.baihoc1.ontap1appkorea.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.baihoc1.ontap1appkorea.Controller.Adapter.ContactAdapter;
import com.example.baihoc1.ontap1appkorea.Model.ContactResult;
import com.example.baihoc1.ontap1appkorea.R;
import com.example.baihoc1.ontap1appkorea.Util.UtilDocJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Contact extends AppCompatActivity {

    RecyclerView rvSdtKhanCap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        init();
        getdata();

    }

    private void getdata() {
        final Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://150.95.115.192/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(Api.class).getContact(new Object()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                 Toast.makeText(Contact.this, "ok", Toast.LENGTH_SHORT).show();
               String strJson = null;
                try {
                    strJson = response.body().string();
                    Gson gson = new Gson();
                    com.example.baihoc1.ontap1appkorea.Model.Contact contact = gson.fromJson
                            (strJson, com.example.baihoc1.ontap1appkorea.Model.Contact.class);
                    LinearLayoutManager linearLayoutManager =
                            new LinearLayoutManager(Contact.this,
                                    LinearLayoutManager.VERTICAL, false);
                    rvSdtKhanCap.setLayoutManager(linearLayoutManager);
                    ContactAdapter adapter = new ContactAdapter();
                    adapter.setContext(Contact.this);
                    adapter.setData(contact.getContactResult());
                    rvSdtKhanCap.setAdapter(adapter);
                    rvSdtKhanCap.addItemDecoration(new DividerItemDecoration
                            (Contact.this, DividerItemDecoration.VERTICAL));


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Contact.this, "thai bai", Toast.LENGTH_SHORT).show();

            }
        });
    }




    private void init() {
        rvSdtKhanCap = findViewById(R.id.rv_sdt_khancap);
    }
}
