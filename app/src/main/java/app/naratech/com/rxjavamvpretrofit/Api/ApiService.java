package app.naratech.com.rxjavamvpretrofit.Api;


import com.jaydenxiao.common.basebean.BaseRespose;

import java.util.List;
import java.util.Map;

import app.naratech.com.rxjavamvpretrofit.activity.login.LoginEntity;
import app.naratech.com.rxjavamvpretrofit.activity.login.LoginModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * des:ApiService
 * Created by xsf
 * on 2016.06.15:47
 */
public interface ApiService {
    public  final static  String BASEURL="http://120.27.13.87:8080/";
    /*@POST("api/login")
    Call<LoginEntity> login();*/
    @POST("api/login")
    Observable<Response<LoginEntity>> login(@Header("Authorization") String header);



}
