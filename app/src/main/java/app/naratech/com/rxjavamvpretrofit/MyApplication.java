package app.naratech.com.rxjavamvpretrofit;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.jaydenxiao.common.commonutils.SPUtils;

/**
 * Created by demo on 2017/4/1.
 */

public class MyApplication extends BaseApplication {
   private static MyApplication instance;



    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logInit(true);
        instance = this;

    }

    public static Context getAppContext() {
        return instance;
    }
    public static Resources getAppResources() {
        return instance.getResources();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 分包
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
