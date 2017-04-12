package app.naratech.com.rxjavamvpretrofit.activity.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.jaydenxiao.common.commonutils.ToastUitl;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.naratech.com.rxjavamvpretrofit.MainActivity;
import app.naratech.com.rxjavamvpretrofit.MyApplication;
import app.naratech.com.rxjavamvpretrofit.R;
import butterknife.Bind;
import butterknife.OnClick;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {
    @Bind(R.id.phone)
    EditText phones;
    @Bind(R.id.pwd)
    EditText pwds;
    @Bind(R.id.btn)
    Button btn;
    private String phone, pwd;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);

    }

    @OnClick(value = {R.id.btn})
    void loginclick() {
        phone = phones.getText().toString();
        pwd = pwds.getText().toString();
        mPresenter.getOneNewsDataRequest(phone, pwd);
    }

    @Override
    public void initView() {



    }


    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }

    @Override
    public void returnOneNewsData(LoginEntity loginModel) {

        int status = loginModel.getStatus();
        if (status == 2000) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        }
        startActivity(MainActivity.class);
        this.finish();
        Log.i("login", "success");
    }

    @Override
    public void returnErrorMsg(String msg) {
        try {
            JSONObject js=new JSONObject(msg);
            int status=js.getInt("status");
            String message=js.getString("message");
            if(status==401){
               // ToastUitl.show( "用户名或密码不正确", 2000);
                ToastUitl.showToastWithImg("用户名或密码不正确", R.mipmap.ic_launcher);
            }else{
                ToastUitl.show(message,2000);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}

