package com.logintest.pc.logintestapplication.http;



import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import com.logintest.pc.logintestapplication.bean.request.LoginUser;
import com.logintest.pc.logintestapplication.bean.response.LoginUserResponseBean;

/**
 * Created by Leo on 2017/6/25.
 */


public interface ApiStores {
   /*
    @GET("user/profile")
    Call<NormalResponse> getUserProfile(@Header("authorization") String token);

    @POST("user/contact")
    Call<EditContactResponse> addUserContact(@Header("authorization") String token, @Body ContactBean contactBean);

    @PUT("doc/{id}")
    Call<EditContactResponse> editPolicy(@Header("authorization") String token, @Path("id") String id, @Body PolicyInfoBean policyInfoBean);
    */


    @POST("viewers/login")
        //Call<ResponseBody> loginPost(@Body RequestBody user);
    Call<LoginUserResponseBean> userLogin(@Header("Content-Type") String str, @Body LoginUser user);
}
