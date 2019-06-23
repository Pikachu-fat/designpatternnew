package com.example.weijianqiang.stragdy.singleton;

import android.util.Log;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public class SingleTon {
    /**
     * first 饿汉模式
     */
//    private static SingleTon singleTon = new SingleTon();
//
//    private SingleTon(){}
//
//    public static SingleTon getInstance(){
//        return singleTon;
//    }

    /**
     * second 懒汉模式
     */
//    private static SingleTon singleTon = null;
//    private SingleTon(){}
//    public static SingleTon getInstance(){
//        if (singleTon == null){
//            singleTon = new SingleTon();
//        }
//    }

    /**
     * DCL
     */
//    private static SingleTon singleTon = null;
//
//    private SingleTon() {
//    }
//
//    public static SingleTon getInstance() {
//        if (singleTon == null) {
//            synchronized (SingleTon.class) {
//                if (singleTon == null) {
//                    singleTon = new SingleTon();
//                }
//            }
//        }
//        return singleTon;
//    }

    /**
     * 推荐使用的模式
     */
    private SingleTon() {
    }

    public static class SingleTonHolder {
        private static final SingleTon singleTon = new SingleTon();
    }

    public static SingleTon getInstance() {
        return SingleTonHolder.singleTon;
    }

    public void showMsg(String tag, String msg) {
        Log.d(tag, "showMsg: " + msg);
    }
}
