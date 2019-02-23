package com.lsz.wd_lsz.activity.login_regsiter_activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.mvp.login_regis_mvp.login_regis_contract.Registercontract;
import com.lsz.wd_lsz.entiey.login_regis_entity.REntity;
import com.lsz.wd_lsz.mvp.login_regis_mvp.login_regis_persenter.Regispresenter;

import java.util.HashMap;

public class RegisterActivity extends BaseMvpActivity<Registercontract.RegisterModel,Registercontract.RegisterPersenter> implements Registercontract.RegisterView  {

    /**
     * 手机号
     */
    private EditText mZhuName;
    /**
     * 获取验证码
     */
    private TextView mZhuYanZheng;
    /**
     * 登录密码
     */
    private EditText mZhuPass;
    private ImageView mEyeZhuce;
    /**
     * 已有账号？ 立即登录
     */
    private TextView mZhuceLogin;
    /**
     * 注册
     */
    private TextView mZhuceButton;
    private String name;
    private String pass;

    @Override
    protected void initClick() {
        /*
        * 点击跳转登录页面
        * */
        mZhuceLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.class);
            }
        });

        /*
        * 点击注册
        * */
        mZhuceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mZhuName.getText().toString().intern();
                pass = mZhuPass.getText().toString().intern();
                if (name.length()!=0&&pass.length()!=0){
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("phone",name);
                    hashMap.put("pwd",pass);
                    presenter.setRegisterList(hashMap);
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
    * 获取资源id
    * */
    protected void initView() {
        mZhuName =  findViewById(R.id.zhu_name);
        mZhuPass =  findViewById(R.id.zhu_pass);
        mEyeZhuce =  findViewById(R.id.eye_zhuce);
        mZhuceLogin =  findViewById(R.id.zhuce_login);
        mZhuceButton =  findViewById(R.id.zhuce_button);
    }
    @Override
    protected int bindLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onsuccess(String relst) {

        REntity lrEntity = new Gson().fromJson(relst, REntity.class);
        String code = lrEntity.getStatus();
        if (code=="0000"){
            startActivity(MainActivity.class);
        }else {
            showToast(lrEntity.getMessage());
        }
    }

    @Override
    public void onFail(String msg) {
        showToast(msg);
    }

    @Override
    public BasePresenter initPresenter() {
        return new Regispresenter();
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
