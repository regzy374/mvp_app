package com.example.android.mvp_app.data.interactor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.android.mvp_app.data.model.Attendee;
import com.example.android.mvp_app.data.local.GuestDBHelper;
import com.example.android.mvp_app.ui.login.LoginPresenter;

import java.sql.SQLClientInfoException;
import java.util.List;

public class AttendeeDataInteractor {

    String idValue;
    String comValue;
    String typeValue;

    private SQLiteDatabase db;
    GuestDBHelper guestDBHelper;

    LoginPresenter presenter;
    public List<Attendee> attendeeList;

    public AttendeeDataInteractor(LoginPresenter presenter, List<Attendee> attendeeList)  {
        this.presenter = presenter;
        this.attendeeList = attendeeList;

    }

    public void updateList(String idValue, String comValue, String typeValue, GuestDBHelper guestDBHelper)
    {
        this.idValue = idValue;
        this.comValue = comValue;
        this.typeValue = typeValue;

        this.guestDBHelper = guestDBHelper;
        db=guestDBHelper.getWritableDatabase();
        guestDBHelper.AddGuestInfo(idValue,comValue,typeValue,db,this);

    }


    public void rowInserted(boolean b)
    {
        if(b == true)
            this.presenter.checkUpdation(true);
        else
            this.presenter.checkUpdation(false);
    }

}
