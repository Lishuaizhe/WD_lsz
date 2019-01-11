package com.lsz.wd_lsz.contract;

import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;
import com.example.lib_core.net.OkhttpCallback;
import com.lsz.wd_lsz.model.Loginmodel;

import java.util.HashMap;

public interface Logincontract {

     abstract class ILoginPersenter extends BasePresenter<ILoginModel,ILoginView>{
         @Override
         public ILoginModel getModel() {
             return new Loginmodel();
         }
         public abstract void  setLoginList(HashMap<String,String> hashMap);
     }

     interface ILoginModel extends IBaseModel{
         void SetLoginList(HashMap<String,String> hashMap , OkhttpCallback okhttpCallback);
     }

     interface ILoginView extends IBaseView{
         void onsuccess(String relst);
         void onFail(String msg);
     }

}
