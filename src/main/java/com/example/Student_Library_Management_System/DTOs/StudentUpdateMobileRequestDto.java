package com.example.Student_Library_Management_System.DTOs;

public class StudentUpdateMobileRequestDto {

    private int id;
    private String mobileNo;

    //DTOs depend on the APIs being called...add
    //attributes as required.


    public StudentUpdateMobileRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
