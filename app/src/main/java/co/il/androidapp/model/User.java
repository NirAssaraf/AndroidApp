package co.il.androidapp.model;



public class User {

    public int userId;
    public String userFirstName;
    public String userLastName;
    public String email;
    public String password;
    public double phoneNumber;
    public String userImg;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserImg() {
        return userImg;
    }
}
