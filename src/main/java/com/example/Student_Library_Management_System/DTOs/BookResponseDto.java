package com.example.Student_Library_Management_System.DTOs;

import com.example.Student_Library_Management_System.Enums.BookGenre;

public class BookResponseDto {
    private String name;
    private int pages;
    private double rating;
    private BookGenre bookgenre;

    public BookResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public BookGenre getBookgenre() {
        return bookgenre;
    }

    public void setBookgenre(BookGenre bookgenre) {
        this.bookgenre = bookgenre;
    }
}
