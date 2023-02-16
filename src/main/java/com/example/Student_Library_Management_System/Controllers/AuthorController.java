package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

//    @PostMapping("/add")
//    public String createAuthor(@RequestBody Author author){
//        return authorService.createAuthor(author);
//    }

    //add using DTO concept
    @PostMapping("/add")
    public String createAuthor(@RequestBody AuthorEntryDto authorEntryDto){
        return authorService.createAuthor(authorEntryDto);
    }

    //get --> author by given id
    //        list of books by author name

    //update --> age by author name/id
    //           list of books

    //delete --> author
    //           a book from list of books
}
