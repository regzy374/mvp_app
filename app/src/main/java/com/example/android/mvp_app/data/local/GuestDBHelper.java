package com.example.android.mvp_app.data.local;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.mvp_app.data.interactor.AttendeeDataInteractor;


public class GuestDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Guestlist.db";
    private static final int DATABASE_VERSION = 1;
    public GuestDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DataBase", "DataBase Created/Opened");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String DbTableName = "CREATE TABLE " + ContractGuest.GuestInfo.TableName + " (" +
                ContractGuest.GuestInfo.Column_Id + " Text," +
                ContractGuest.GuestInfo.Column_Company + " Text," +
                ContractGuest.GuestInfo.Column_Type + " Text" +
                "); ";
        db.execSQL(DbTableName);
        Log.e("DataBase", "Table Created");
    }

    public void AddGuestInfo(String id, String company, String type, SQLiteDatabase dbob,AttendeeDataInteractor interactor) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContractGuest.GuestInfo.Column_Id, id);
        contentValues.put(ContractGuest.GuestInfo.Column_Company, company);
        contentValues.put(ContractGuest.GuestInfo.Column_Type, type);
        long rowNumber= dbob.insert(ContractGuest.GuestInfo.TableName, null, contentValues);
        if(rowNumber!=1) {
            Log.e("DataBase", "1 row inserted");
            interactor.rowInserted(true);
            }
            else {
            Log.e("DataBase", "no row inserted");
            interactor.rowInserted(false);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" Drop table if exists " + ContractGuest.GuestInfo.TableName);
        onCreate(db);

    }
}
