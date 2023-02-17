package com.example.Student_Library_Management_System.DTOs;

import java.util.List;

public class AuthorResponseDto {

    private String name;
    private int age;
    private String country;

    List<BookResponseDto> bookResponseDtoList ;

    public AuthorResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<BookResponseDto> getBookResponseDtoList() {
        return bookResponseDtoList;
    }

    public void setBookResponseDtoList(List<BookResponseDto> bookResponseDtoList) {
        this.bookResponseDtoList = bookResponseDtoList;
    }
}
