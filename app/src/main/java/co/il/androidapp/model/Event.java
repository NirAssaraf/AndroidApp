package co.il.androidapp.model;

import android.location.Location;

import java.util.Date;
import java.util.List;

public class Event {
    public String EventName;
    public String EventDetails;
    public Date EventDate;
    public String EventImg;
    public Location EventLocation;
    public List<Product> products;
    public List<Chore> chorelist;
    public List<User>userlist;
}
