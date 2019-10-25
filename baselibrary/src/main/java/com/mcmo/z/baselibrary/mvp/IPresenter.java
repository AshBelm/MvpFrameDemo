package com.mcmo.z.baselibrary.mvp;

import java.lang.ref.WeakReference;

public interface IPresenter<T extends IView>{

    void setView(T view);

    T getView();
}
