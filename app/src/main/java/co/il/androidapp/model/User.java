package co.il.androidapp.model;

import android.provider.ContactsContract;

import java.net.PasswordAuthentication;
import java.util.List;

public class User {

    public int userId;
    public String userFirstName;
    public String userLastName;
    public ContactsContract.CommonDataKinds.Email userEmail;
    public ContactsContract.CommonDataKinds.Phone userPhone;
    public PasswordAuthentication userPasswordAuthentication;
    public String userImg;

}
