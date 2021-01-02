package co.il.androidapp.model;

import android.location.Location;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Event implements Serializable {

    public int EventId;
    public String EventName;
    public String EventDetails;
    public String eventTime;
    public String EventImg;
    public int position;

}
