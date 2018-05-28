package com.example.android.mvp_app.utils.mvp;


import android.content.Context;

public interface IBaseView {

    void showToastMessage(String message);

    void setProgressBar(boolean show);

    Context getContext();
}

