package com.mcmo.z.baselibrary.mvp;

public interface IView {

    void showToast(int resId);
    void showToast(String msg);
    void showLoading();
    void dismissLoading();
}
