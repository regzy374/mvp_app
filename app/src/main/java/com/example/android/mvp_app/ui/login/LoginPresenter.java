package com.example.android.mvp_app.ui.login;

import android.content.Context;
import android.util.Log;

import com.example.android.mvp_app.data.interactor.AttendeeDataInteractor;
import com.example.android.mvp_app.data.local.GuestDBHelper;
import com.example.android.mvp_app.data.model.Attendee;
import com.example.android.mvp_app.utils.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter{

    String idValue;
    String comValue;
    String typeValue;

    GuestDBHelper guestDBHelper;

    private List<Attendee> attendeeList = new ArrayList<>();
    AttendeeDataInteractor interactor;

    public LoginPresenter(LoginContract.View view)
    {
        this.view = view;
        this.interactor = new AttendeeDataInteractor(this, attendeeList);
    }

    public void checkUpdation(boolean b)
    {
        if (b == true) {
            Log.i("TAF","LALALA");
            //view.showToastMessage("inerted successfully");
            view.showMymessae(b);

        } else {
            Log.i("TAF","LALALALALALALALALLALA");
            view.showMymessae(b);

        }
    }

    @Override
    public void updateAttendeeList(String idValue, String comValue, String typeValue) {
        this.idValue = idValue;
        this.comValue = comValue;
        this.typeValue= typeValue;
        guestDBHelper= new GuestDBHelper(view.getContext());
        this.interactor.updateList(idValue, comValue, typeValue, guestDBHelper);
    }

}
