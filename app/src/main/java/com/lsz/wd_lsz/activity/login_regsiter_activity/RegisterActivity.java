package com.lsz.wd_lsz.activity.login_regsiter_activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.mvp.contract.login_regis_contract.Registercontract;
import com.lsz.wd_lsz.entiey.login_regis_entity.REntity;
import com.lsz.wd_lsz.mvp.presenter.login_regis_persenter.Regispresenter;

import java.util.HashMap;

public class RegisterActivity extends BaseMvpActivity<Registercontract.RegisterModel,Registercontract.RegisterPersenter> implements Registercontract.RegisterView  {

    /**
     * 手机号
     */
    private EditText mZhuName;
    /**
     * 验证码
     */
    private EditText mZhuYan;
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
                if (name.length()!=0&&pass.length()!=0){
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("mobile",name);
                    hashMap.put("password",pass);
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
        name = mZhuName.getText().toString().intern();
        pass = mZhuPass.getText().toString().intern();
    }

    /*
    * 获取资源id
    * */
    protected void initView() {
        mZhuName =  findViewById(R.id.zhu_name);
        mZhuYan =  findViewById(R.id.zhu_yan);
        mZhuYanZheng =  findViewById(R.id.zhu_yan_zheng);
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
        String msg = lrEntity.getMsg();
        if ("注册成功".equals(msg)){
            startActivity(MainActivity.class);
        }else if ("天呢！用户已注册".equals(msg)){
            showToast("用户已经注册过了");
            startActivity(MainActivity.class);
        }else if ("请输入正确的手机号码".equals(msg)){
            showToast("请输入正确的手机号码");
        }else {
            showToast("在检查一遍吧！");
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
