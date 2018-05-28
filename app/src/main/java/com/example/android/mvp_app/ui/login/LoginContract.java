package com.example.android.mvp_app.ui.login;

import android.content.Context;

import com.example.android.mvp_app.data.model.Attendee;
import com.example.android.mvp_app.utils.mvp.IBasePresenter;
import com.example.android.mvp_app.utils.mvp.IBaseView;

import java.util.List;



public interface LoginContract {

        interface View extends IBaseView {

       // void showAttendeeList(List<Attendee> attendeeList);
        void showMymessae(boolean b);
        void check(boolean b);

    }

      interface Presenter extends IBasePresenter<View> {
       // void getAttendeeList(Context context);

        void updateAttendeeList(String idValue, String comValue, String typeValue);
    }
}