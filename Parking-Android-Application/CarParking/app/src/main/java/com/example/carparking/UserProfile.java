package com.example.carparking;

public class UserProfile {

    String username;
    String useremail;
    String userage;

    public UserProfile(){

    }

    public UserProfile(String username, String useremail, String userage) {
        this.username = username;
        this.useremail = useremail;
        this.userage = userage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }
}
