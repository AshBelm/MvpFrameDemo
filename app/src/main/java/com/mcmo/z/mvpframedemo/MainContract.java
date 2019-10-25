package com.mcmo.z.mvpframedemo;


import com.mcmo.z.baselibrary.mvp.IPresenter;
import com.mcmo.z.baselibrary.mvp.IView;

public interface MainContract {
    interface View extends IView {
        void changeText();
    }
    interface Presenter extends IPresenter<View> {
        void print();
    }
}
