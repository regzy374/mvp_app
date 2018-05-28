package com.example.android.mvp_app.data.model;

public class Attendee {

    public String id;
    public String company;
    public String type;


    public Attendee() {
    }

    public Attendee(String attendanceId, String attendeeCompany, String attendeeType) {
        this.id = attendanceId;

        this.company = attendeeCompany;
        this.type = attendeeType;
    }

    //Getter -- @return id
    public String getId() {
        return id;
    }

    //Setter -- @param attendanceId
    public void setId(String attendanceId) {
        this.id = attendanceId;
    }

        //Getter -- @return company
    public String getCompany() {
        return company;
    }

    //Setter -- @param company
    public void setCompany(String company) {
        this.company = company;
    }

    //Getter -- @return type
    public String getType() {
        return type;
    }

    //Setter -- @param type
    public void setType(String type) {
        this.type = type;
    }

    }
