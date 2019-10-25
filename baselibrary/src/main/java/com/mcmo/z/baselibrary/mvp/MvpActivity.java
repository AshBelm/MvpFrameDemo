package com.mcmo.z.baselibrary.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public abstract class MvpActivity<T extends IPresenter> extends AppCompatActivity implements IView {
    private T presenter;

    public T getPresenter() {
        return presenter;
    }

    public abstract T createPresenter();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.setView(this);
    }

    @Override
    public void showToast(int resId) {
        // TODO: 2019/9/9
    }

    @Override
    public void showToast(String msg) {
        // TODO: 2019/9/9  
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        // TODO: 2019/9/9  
    }

    @Override
    public void dismissLoading() {
        // TODO: 2019/9/9
    }
}
