package com.example.android.mvp_app.data.local;

import android.provider.BaseColumns;

public class ContractGuest {

     public static final class GuestInfo implements BaseColumns
     {
         public static final String TableName="AttendeeList";
         public static final String Column_Id="Id";
         public static final String Column_Company="Comapny";
         public static final String Column_Type="Type";
     }

}
