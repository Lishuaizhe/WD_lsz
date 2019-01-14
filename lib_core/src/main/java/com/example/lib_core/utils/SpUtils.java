package com.example.lib_core.utils;

/**
 * sharedprefrences工具类
 */
public class SpUtils {

/*
    private final  String JI_ZHU ="ji_zhu";

    private  static  SpUtils spUtils;

    private SpUtils(){

    }

    public static  SpUtils getSpUtils(){
        if (spUtils==null){
            synchronized (SpUtils.class){
                if (spUtils==null){
                    spUtils = new SpUtils();
                }
            }
        }
        return spUtils;
    }

    */
/*
    * sp实例化
    * *//*

    private SharedPreferences getSP(){
        SharedPreferences sharedPreferences = BaseApp.getContext().getSharedPreferences(JI_ZHU,Context.MODE_PRIVATE);
        if (sharedPreferences!=null){
            return sharedPreferences;
        }
        return null;
    }

    public void PutSp(String key,String value){
        getSP().edit().putString(key,value).commit();
    }

    public String getSp(String key){
        return getSP().getString(key,"");
    }
*/

}
