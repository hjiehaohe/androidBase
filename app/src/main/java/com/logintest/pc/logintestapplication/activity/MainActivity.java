package com.logintest.pc.logintestapplication.activity;

import com.google.gson.Gson;
import com.logintest.pc.logintestapplication.bean.response.Repo;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.logintest.pc.logintestapplication.common.BaseActivity;

import com.logintest.pc.logintestapplication.R;
import com.logintest.pc.logintestapplication.bean.request.LoginUser;
import com.logintest.pc.logintestapplication.bean.response.LoginUserResponseBean;

import com.logintest.pc.logintestapplication.http.ApiStores;
import com.logintest.pc.logintestapplication.http.HttpClient;

import org.json.JSONObject;

import java.text.BreakIterator;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import retrofit2.http.POST;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private String userName;
    private String password;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    /**
     * 初始化视图
     */
    protected void initView(){

    };

    /**
     * 初始化数据
     */
    protected void initData(){
        Button loginButton = findViewById(R.id.loginButton);
        Button resgiterButton = findViewById(R.id.registertButton);

        loginButton.setOnClickListener(this);
        resgiterButton.setOnClickListener(this);
    };


    /**
     * 初始化事件
     */
    protected void initEvent(){

    };


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void getUserMessage(){
        EditText userNameText = (EditText) findViewById(R.id.userName);
        userName = userNameText.getText().toString();

        EditText passwordText = (EditText) findViewById(R.id.password);
        password = passwordText.getText().toString();

    }

    public void setUser(){
        if(userName.equals("")){
            Toast.makeText(getApplicationContext(),"Username can't null",Toast.LENGTH_LONG).show();
            return;
        }

        if(password.equals("")){
            Toast.makeText(getApplicationContext(),"Password can't null",Toast.LENGTH_LONG).show();
            return;
        }

        LoginUser user = new LoginUser(userName, password);
        ApiStores apiStores = HttpClient.getApiStores();
        Call<LoginUserResponseBean>  call = apiStores.userLogin("application/json",user);

        call.enqueue(new Callback<LoginUserResponseBean>() {
            @Override
            public void onResponse(Call<LoginUserResponseBean> call, Response<LoginUserResponseBean> response) {
                if (response.isSuccessful()){
                    //Log.e("APPid",response.body().get_id());

                    //
                }else {
                    ResponseBody responseBody = response.errorBody();
                    Toast.makeText(getApplicationContext(),"Username or password error",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<LoginUserResponseBean> call, Throwable t) {
                Log.e("App","POST flase");
                t.printStackTrace();
            }
        });
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginButton:
                getUserMessage();
                setUser();
                break;
            case R.id.registertButton:
                Toast.makeText(MainActivity.this,"haven't this function",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
