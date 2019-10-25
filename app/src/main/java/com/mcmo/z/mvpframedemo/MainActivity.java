package com.mcmo.z.mvpframedemo;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mcmo.z.baselibrary.mvp.MvpActivity;
import com.mcmo.z.baselibrary.net.RetrofitMgr;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends MvpActivity<MainContract.Presenter> implements MainContract.View {
    TextView tv;

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://t.weather.sojson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getLoggerClient())
                .build();

        RetrofitMgr.getInstance().setDefaultRetrofit(retrofit);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().print();
            }
        });
        SerApi api = RetrofitMgr.getInstance().create(SerApi.class);
        Call<ResponseBody> a = api.requestBaidu(101030100);
        a.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("aaa", "onResponse: "+response.code());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("aaa", "onResponse: error");
            }
        });
    }


    private int count = 1;

    @Override
    public void changeText() {
        tv.setText("aaa" + count++);
    }

    private OkHttpClient getLoggerClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("TT NET ", "====> "+message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        return client;
    }
}
