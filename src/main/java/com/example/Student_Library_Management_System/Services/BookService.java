package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

//    @Autowired
//    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

   /* public String addBook(Book book){

        //I want to get the AuthorEntity ???
        int authorId = book.getAuthor().getId(); //id passed via author object during book Postman

        //Now I will be fetching the authorEntity
        Author author = authorRepository.findById(authorId).get();

        //H.W Do exception handling

        //Basic attributes are already set from postman
        //We need to update the listOfBooks written in the parent class
        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);
        author.setBooksWritten(currentBooksWritten); //-->mine

        //Setting the foreign key attr in the child class :
        book.setAuthor(author);

        //Now the book is to be saved, but also author is also to be saved.
        //Why do we need to again save (updating) the author ??
        //bcz the author Entity has been updated....we need to re_save/update it.
        //.save function works both as save function and as update function
        authorRepository.save(author);
        //bookRepo.save is not required : bcz it will be auto called by cascading effect

        return "Book Added successfully";
    }*/

    //using DTO
    public String addBook(BookRequestDto bookRequestDto){

        int authorId = bookRequestDto.getAuthorId();
        Author author = authorRepository.findById(authorId).get();

        //Convertor
        //We have created this Entity so that we can save it into the DB.
        Book book = new Book();
        //Basic attributes are being from Dto to the Entity Layer
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());
        book.setRating(bookRequestDto.getRating());
        book.setBookGenre(bookRequestDto.getBookGenre());
        book.setIssued(false);
        //Setting the foreign key attr in the child class :
        book.setAuthor(author);

        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);

        authorRepository.save(author);

        return "Book Added successfully";
    }
}
