package com.mcmo.z.baselibrary.mvp;

import java.lang.ref.WeakReference;

public class BasePresenter<T extends IView> implements IPresenter<T>{
    private WeakReference<T> mViewRef;
    public void setView(T view) {
        clearViewIfNeed();
        mViewRef = new WeakReference<>(view);
    }

    private void clearViewIfNeed() {
        if (mViewRef != null && mViewRef.get() != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public T getView() {
        return mViewRef.get();
    }
}
