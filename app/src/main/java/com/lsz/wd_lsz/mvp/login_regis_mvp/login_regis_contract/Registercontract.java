package com.lsz.wd_lsz.mvp.login_regis_mvp.login_regis_contract;

import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;
import com.example.lib_core.net.OkhttpCallback;
import com.lsz.wd_lsz.mvp.login_regis_mvp.login_regis_model.Registermodel;

import java.util.HashMap;

public interface Registercontract {

     abstract class RegisterPersenter extends BasePresenter<RegisterModel,RegisterView>{
         @Override
         public RegisterModel getModel() {
             return new Registermodel();
         }
         public abstract void  setRegisterList(HashMap<String,String> hashMap);
     }

     interface RegisterModel extends IBaseModel{
         void SetRegisterList(HashMap<String, String> hashMap, OkhttpCallback okhttpCallback);
     }

     interface RegisterView extends IBaseView{
         void onsuccess(String relst);
         void onFail(String msg);
     }
}