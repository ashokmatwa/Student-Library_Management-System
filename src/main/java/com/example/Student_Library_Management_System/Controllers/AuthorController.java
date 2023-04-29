package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.DTOs.BookResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //it causes INFINITE RECURSION --> STACKOVERFLOW
//    @GetMapping("/getAuthor")
//    public Author getAuthor(@RequestParam("authorId") int authorId){
//        return authorService.getAuthor(authorId);
//    }

    //using ResponseDto
    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId") int authorId){
        return authorService.getAuthor(authorId);
    }

    @GetMapping("/getBooks")
    public List<BookResponseDto> getBooks(@RequestParam("authorName") String authorName){
        return authorService.getBookList(authorName);
    }

    //get --> author by given id
    //        list of books by author name

    //update --> age by author name/id

//    @PutMapping("updateAge")
//    public String updateAge(@RequestParam("authorId") int authorId, @RequestParam("age") int newAge){
//        return authorService.updateAge(authorId, newAge);
//    }

    @PutMapping("updateAge")
    public String updateAge(@RequestBody AuthorEntryDto authorEntryDto){
        return authorService.updateAge(authorEntryDto);
    }

    //delete --> author
    //           a book from list of books
}
