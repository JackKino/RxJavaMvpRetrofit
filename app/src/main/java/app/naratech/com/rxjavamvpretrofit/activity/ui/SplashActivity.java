package app.naratech.com.rxjavamvpretrofit.activity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.SPUtils;

import app.naratech.com.rxjavamvpretrofit.R;
import app.naratech.com.rxjavamvpretrofit.activity.login.LoginActivity;


/**
 * @desc 启动屏
 * Created by devilwwj on 16/1/23.
 */
public class SplashActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
// 判断是否是第一次开启应用
        boolean isFirstOpen = SPUtils.getSharedBooleanData(this, "FIRST_OPEN");
        // 如果是第一次启动，则先进入功能引导页
        if (!isFirstOpen) {
            Intent intent = new Intent(this, WelcomeGuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // 如果不是第一次启动app，则正常显示启动屏
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                enterHomeActivity();
            }
        }, 2000);
    }



    private void enterHomeActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
