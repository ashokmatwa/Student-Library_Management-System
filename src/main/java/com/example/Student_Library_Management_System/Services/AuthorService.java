package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        //Solution : Convert authorEntryDto ---> Author **************IMP***********

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

}
