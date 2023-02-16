package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

//    @PostMapping("/add")
//    public String addBook(@RequestBody Book book){
//        return bookService.addBook(book);
//    }

    //using DTO
    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.addBook(bookRequestDto);
    }

    //GET --> book by given id
    //        author by book name
    //        genre by book name
    //        issued status by book name

    //update --> issued status
    //           ratings

    //delete --> a book by id or name
}
