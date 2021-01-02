package co.il.androidapp.model;

import android.location.Location;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Event implements Serializable {

    private int EventId;
    private String EventName;
    private String EventDetails;
    private String eventTime;
    private String EventImg;
    private int position;

    public int getEventId() {
        return EventId;
    }

    public void setEventId(int eventId) {
        EventId = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventDetails() {
        return EventDetails;
    }

    public void setEventDetails(String eventDetails) {
        EventDetails = eventDetails;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventImg() {
        return EventImg;
    }

    public void setEventImg(String eventImg) {
        EventImg = eventImg;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


}
