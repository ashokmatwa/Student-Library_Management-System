package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //1. inbuilt
    //2. inbuilt + define
    //3. complex sql queries

    //only define the function as it is in interface
    Student findByEmail(String email);

    //sql --> select * from student where country=India;
    List<Student> findByCountry(String country);
}
