package com.mcmo.z.mvpframedemo;

import android.util.Log;

import com.mcmo.z.baselibrary.mvp.BasePresenter;


public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    private static final String TAG = "MainPresenter";
    @Override
    public void print() {
        getView().changeText();
        getView().showToast("hahahah");
    }
}
