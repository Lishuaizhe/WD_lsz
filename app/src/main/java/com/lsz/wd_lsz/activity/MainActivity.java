package com.lsz.wd_lsz.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.contract.Logincontract;
import com.lsz.wd_lsz.entiey.LREntity;
import com.lsz.wd_lsz.presenter.Loginpresenter;

import java.util.HashMap;

public class MainActivity extends BaseMvpActivity<Logincontract.ILoginModel,Logincontract.ILoginPersenter> implements Logincontract.ILoginView {

    /**
     * 手机号
     */
    private EditText mEditName;
    /**
     * 登录密码
     */
    private EditText mEditPass;
    private ImageView mEyeLogin;
    /**
     * 记住密码
     */
    private CheckBox mCheckBox;
    /**
     * 快速注册
     */
    private TextView mZhuCe;
    /**
     * 登录
     */
    private TextView mDengText;


    @Override
    protected void initClick() {
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
                String name = mEditName.getText().toString();
                String pass = mEditPass.getText().toString();
                if (name.length()!=0&&pass.length()!=0){
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("mobile",name);
                    hashMap.put("password",pass);
                    presenter.setLoginList(hashMap);
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
        if ("登录成功".equals(lrEntity.getMsg())){
            //setIntent();
            showToast("登陆成功");
            startActivity(HoneActivity.class);
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
