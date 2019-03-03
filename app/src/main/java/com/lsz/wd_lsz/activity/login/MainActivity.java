package com.lsz.wd_lsz.activity.login;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.activity.register.RegisterActivity;
import com.lsz.wd_lsz.activity.fragmentmain.FragmentActivity;
import com.lsz.wd_lsz.mvp.loginmvp.Logincontract;
import com.lsz.wd_lsz.entiey.loginentity.LREntity;
import com.lsz.wd_lsz.mvp.loginmvp.Loginpresenter;
import com.lsz.wd_lsz.user.uitl.SpUtil;

import java.util.HashMap;

public class MainActivity extends BaseMvpActivity<Logincontract.ILoginModel,Logincontract.ILoginPersenter> implements Logincontract.ILoginView {

    private EditText mEditName;
    private EditText mEditPass;
    private ImageView mEyeLogin;
    private CheckBox mCheckBox;
    private TextView mZhuCe;
    private TextView mDengText;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void initClick() {

        mEyeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });

        //点击进入注册页面
        mZhuCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(RegisterActivity.class);
            }
        });
        //点击登录
        mDengText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               String  name = mEditName.getText().toString();
                String  pass = mEditPass.getText().toString();

                editor = sharedPreferences.edit();
                if (name.length()!=0&&pass.length()!=0){
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("phone",name);
                    hashMap.put("pwd",pass);

                    if (mCheckBox.isChecked()){
                        editor.putBoolean("Da", true);
                        editor.putString("username", name);
                        editor.putString("password", pass);
                        presenter.setLoginList(hashMap);
                    }else {
                        editor.clear();
                        presenter.setLoginList(hashMap);
                    }
                    editor.apply();
                }else {
                    showToast("请输入账号密码");
                }
            }
        });

    }
    /*
     * 加载数据
     * */
    protected void initData() {
        super.initData();
    }

    /*
     * 加载视图
     * */
    protected void initView() {
        mEditName =  findViewById(R.id.edit_name);
        mEditPass =  findViewById(R.id.edit_pass);
        mEyeLogin =  findViewById(R.id.eye_login);
        mCheckBox =  findViewById(R.id.check_box);
        mDengText =  findViewById(R.id.deng_text);
        mZhuCe =  findViewById(R.id.zhu_ce);

        View decorView = getWindow().getDecorView();
//        SYSTEM_UI_FLAG_FULLSCREEN表示全屏的意思，也就是会将状态栏隐藏
        //设置系统UI元素的可见性
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isRemember = sharedPreferences.getBoolean("Da", false);

        if (isRemember){
            //账号和密码都设置到文本框
            String username = sharedPreferences.getString("username","");
            String password = sharedPreferences.getString("password","");

            mEditName.setText(username);
            mEditPass.setText(password);
            mCheckBox.setChecked(true);
        }

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    /*
    * 成功
    * */
    @Override
    public void onsuccess(String relst) {
        LREntity lrEntity = new Gson().fromJson(relst, LREntity.class);
        if ("0000".equals(lrEntity.getStatus())){
            showToast("登录成功");


            SpUtil.putString(this,"userid",lrEntity.getResult().getUserId()+"");
            SpUtil.putString(this,"sessionid",lrEntity.getResult().getUserId()+"");
//            edit.putInt("userid",lrEntity.getResult().getUserId());
//            edit.putString("sessionid",lrEntity.getResult().getSessionId());
//            edit.commit();*/
//            int usetid = userSettings.getInt("userid", 0);
            startActivity(FragmentActivity.class);
        }else {
            showToast("账号密码错误!");
        }
    }

    /*
    * 失败
    * */
    @Override
    public void onFail(String msg) {
        showToast(msg);
    }

    @Override
    public BasePresenter initPresenter() {
        return new Loginpresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void failure(String msg) {

    }
}
