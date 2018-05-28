package com.example.android.mvp_app.utils.mvp;

public interface IBasePresenter<ViewT> {

    void onViewActive(ViewT view);

    void onViewInactive();
}

