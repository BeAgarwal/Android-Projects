package com.example.carparking;

public class UserBooking {
    private String slot;
    private String place;

    public UserBooking(){

    }

    public UserBooking(String slot, String place) {
        this.slot = slot;
        this.place = place;
    }


    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
