package app.naratech.com.rxjavamvpretrofit.activity.login;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by demo on 2017/4/1.
 */

public interface LoginApi {
    @Headers(("Content_type:application/json;charset=utf-8"))
    @POST("api/login")
    Call<LoginModel> login();
    //Call<LoginModel> login(@Query("phone") String phone, @Query("pwd") String pwd);

}
