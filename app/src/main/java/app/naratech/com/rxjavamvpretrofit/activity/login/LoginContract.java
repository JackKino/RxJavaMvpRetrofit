package app.naratech.com.rxjavamvpretrofit.activity.login;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import rx.Observable;

/**
 * Created by demo on 2017/4/1.
 */

public class LoginContract {

    interface Model extends BaseModel {
        //请求获取新闻
        //Observable<LoginModel> getOneNewsData(String phone,String pwd);
    }

    interface View extends BaseView {
        //返回获取的新闻
        void returnOneNewsData(LoginEntity LoginEntity);
        void returnErrorMsg(String msg);
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        //发起获取单条新闻请求
        public abstract void getOneNewsDataRequest(String phone,String pwd);
    }
}
