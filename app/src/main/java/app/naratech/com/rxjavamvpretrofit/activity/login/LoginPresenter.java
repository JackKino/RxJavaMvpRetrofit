package app.naratech.com.rxjavamvpretrofit.activity.login;

import org.json.JSONException;
import org.json.JSONObject;

import app.naratech.com.rxjavamvpretrofit.Api.Api;
import app.naratech.com.rxjavamvpretrofit.Api.ApiService;

/**
 * Created by demo on 2017/4/1.
 */

public class LoginPresenter extends LoginContract.Presenter {
    @Override
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
        ApiService loginService=Api.getMovieService("http://192.168.1.109:12345/",headers);
        LoginService.login(loginService, new RequestCallback<LoginEntity>() {
            @Override
            public void onRequestSucess(LoginEntity result) {
                     mView.returnOneNewsData(result);
            }

            @Override
            public void onRequestFailed(String msg) {

            }
        });
    }
}
