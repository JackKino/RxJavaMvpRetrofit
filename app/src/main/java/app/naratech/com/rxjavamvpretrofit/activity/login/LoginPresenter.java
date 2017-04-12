package app.naratech.com.rxjavamvpretrofit.activity.login;

import android.util.Log;

import com.jaydenxiao.common.commonutils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import app.naratech.com.rxjavamvpretrofit.Api.Api;
import app.naratech.com.rxjavamvpretrofit.Api.ApiService;
import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;

/**
 * Created by demo on 2017/4/1.
 */

public class LoginPresenter extends LoginContract.Presenter {
    @Override
    public void getOneNewsDataRequest(String phone, String pwd) {
        StringBuilder sb = new StringBuilder();
        sb.append(phone);
        sb.append(":");
        sb.append(pwd);
        String base = android.util.Base64.encodeToString(sb.toString().getBytes(), android.util.Base64.NO_WRAP);
        String header = new StringBuilder().append("Basic ").append(base).toString();
        mRxManage.add(Api.getInstance().getRetrofit()
                .create(ApiService.class)
                .login(header)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<LoginEntity>>() {
                    @Override
                    public void onCompleted() {
                        Log.i("error","completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("error",e.toString());
                    }

                    @Override
                    public void onNext(Response<LoginEntity> loginEntityResponse) {
                        String err= null;

                        int code=loginEntityResponse.code();
                        if(code==200){
                            LoginEntity data=loginEntityResponse.body();
                            mView.returnOneNewsData(data);
                            Log.i("error", "success");
                        }else {
                            try {
                                err = loginEntityResponse.errorBody().source().readUtf8().trim();
                                mView.returnErrorMsg(err);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Log.i("error", err + "   " + code);
                        }
                    }
                })
        );
    }
    /*@Override
    public void getOneNewsDataRequest(String phone, String pwd) {
        StringBuilder sb=new StringBuilder();
        sb.append(phone);
        sb.append(":");
        sb.append(pwd);
        String base= android.util.Base64.encodeToString(sb.toString().getBytes(), android.util.Base64.NO_WRAP);
        String header=new StringBuilder().append("Basic ").append(base).toString();
        JSONObject headers=new JSONObject();
        try {
            headers.put("key","Authorization");
            headers.put("value",header);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ApiService loginService=Api.getMovieService("http://120.27.13.87:8080/",headers);
        LoginService.login(loginService, new RequestCallback<LoginEntity>() {
            @Override
            public void onRequestSucess(LoginEntity result) {
                LogUtils.logi("header","key="+result.getResult()+"   value="+result.getMessage());
                     mView.returnOneNewsData(result);
            }

            @Override
            public void onRequestFailed(String msg) {

            }
        });
    }*/

}
