package com.mcmo.z.baselibrary.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class MvpFragment<T extends IPresenter> extends Fragment implements IView {
    private T presenter;

    public T getPresenter() {
        return presenter;
    }

    public abstract T createPresenter();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.setView(this);
    }

    @Override
    public void showToast(int resId) {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
