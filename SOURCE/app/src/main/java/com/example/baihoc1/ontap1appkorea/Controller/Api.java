package com.example.baihoc1.ontap1appkorea.Controller;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    @POST("Service/GetListPlace")
    Call<ResponseBody> getListPlace(@Body Object object);

    @POST("Service/GetListContact")
    Call<ResponseBody> getContact (@Body Object object);

    @POST("Service/GetListPromotion")
    Call<ResponseBody> getPromotion (@Body Object object);
}
