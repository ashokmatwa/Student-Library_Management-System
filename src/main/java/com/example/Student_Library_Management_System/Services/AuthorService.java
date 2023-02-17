package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.DTOs.BookResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

//    public String createAuthor(Author author){
//        authorRepository.save(author);
//        return "Author added successfully";
//    }

    //using DTO
    public String createAuthor(AuthorEntryDto authorEntryDto){
        //Important step is : in the params : the object i
        //of type DTO but the repository interacts only with entities

        //**************IMP***********
        //Solution : Convert authorEntryDto ---> Author

        //Created an object of type Author
        Author author = new Author();
        //we are setting its attribute so that we can save
        //correct values in the db.
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());

        authorRepository.save(author);
        return "Author added successfully";
    }

//    public Author getAuthor(int authorId){
//        return authorRepository.findById(authorId).get();
//    }
     public AuthorResponseDto getAuthor(int authorId){

        Author author = authorRepository.findById(authorId).get();

         //List<Book> --> List<BookResponseDto>
        List<Book> booksWritten = author.getBooksWritten();
        List<BookResponseDto> bookResponseDtoList = new ArrayList<>();

        for(Book book : booksWritten){
            BookResponseDto bookResponseDto = new BookResponseDto();

            bookResponseDto.setName(book.getName());
            bookResponseDto.setPages(book.getPages());
            bookResponseDto.setRating(book.getRating());
            bookResponseDto.setBookgenre(book.getBookGenre());

            bookResponseDtoList.add(bookResponseDto);
        }

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setCountry(author.getCountry());

        authorResponseDto.setBookResponseDtoList(bookResponseDtoList);

        return authorResponseDto;
    }
}
