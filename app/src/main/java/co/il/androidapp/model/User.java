package co.il.androidapp.model;

import android.provider.ContactsContract;

import java.net.PasswordAuthentication;
import java.util.List;

public class User {
    public String userFirstName;
    public String userLastName;
    public ContactsContract.CommonDataKinds.Email userEmail;
    public ContactsContract.CommonDataKinds.Phone userPhone;
    public PasswordAuthentication userPasswordAuthentication;
    public String userImg;
    public List<Event> userEventList;
    public List<User> userContactList;
}
