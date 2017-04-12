package app.naratech.com.rxjavamvpretrofit.activity.login;

import android.util.Log;

import com.jaydenxiao.common.commonutils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import app.naratech.com.rxjavamvpretrofit.Api.ApiService;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by demo on 2017/4/1.
 */

public class LoginService {


    /**
     * 登录
     */
    public static void login(ApiService loginservice, final RequestCallback<LoginEntity> cbk) {

/*
        Call<LoginEntity> call = loginservice.login();

        call.enqueue(new retrofit2.Callback<LoginEntity>() {
            @Override
            public void onResponse(Call<LoginEntity> call, retrofit2.Response<LoginEntity> response) {
               LoginEntity data = response.body();

                cbk.onRequestSucess(data);
            }

            @Override
            public void onFailure(Call<LoginEntity> call, Throwable t) {
                cbk.onRequestFailed(t.getMessage());
            }
        });
    }*/
    }
}
