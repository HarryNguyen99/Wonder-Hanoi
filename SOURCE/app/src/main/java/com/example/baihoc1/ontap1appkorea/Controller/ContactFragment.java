package com.example.baihoc1.ontap1appkorea.Controller;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.baihoc1.ontap1appkorea.Controller.Adapter.ContactAdapter;
import com.example.baihoc1.ontap1appkorea.Model.Contact;
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
public class ContactFragment extends Fragment {
    RecyclerView rvSdtKhanCap;
    View vRost;


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vRost = inflater.inflate(R.layout.fragment_contact, container, false);
        init();
        getdata();
        return vRost;
    }

    private void init() {
    rvSdtKhanCap = vRost.findViewById(R.id.rv_sdt_khancap);

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
                //Toast.makeText(getActivity(), "ok", Toast.LENGTH_SHORT).show();
                String strJson = null;
                try {
                    strJson = response.body().string();
                    Gson gson = new Gson();
                    com.example.baihoc1.ontap1appkorea.Model.Contact contact = gson.fromJson
                            (strJson, com.example.baihoc1.ontap1appkorea.Model.Contact.class);
                    LinearLayoutManager linearLayoutManager =
                            new LinearLayoutManager(ContactFragment.this
                            ,LinearLayoutManager.VERTICAL,false);
                    rvSdtKhanCap.setLayoutManager(linearLayoutManager);
                    ContactAdapter adapter = new ContactAdapter();
                    adapter.setContext(ContactFragment.this);
                    adapter.setData(contact.getContactResult());
                    rvSdtKhanCap.setAdapter(adapter);
                    rvSdtKhanCap.addItemDecoration(new DividerItemDecoration
                            (ContactFragment.this, DividerItemDecoration.VERTICAL));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "that bai", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
