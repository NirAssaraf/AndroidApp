package co.il.androidapp.model;

import android.location.Location;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Event implements Serializable {
    public int Eventid;
    public String EventName;
    public String EventDetails;
    public String eventTime;
//    public int EventDay;
//    public int EventMonth;
//    public int EventYear;
    public String EventImg;
//    public String EventLocation;
    public int position;

}
