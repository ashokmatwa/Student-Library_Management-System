package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/getName")
    public String getNameByEmail(@RequestParam("email") String email){
        return studentService.getNameByEmail(email);
    }

    @PutMapping("/update_mobileNo")
    public String updateMobileNo(@RequestBody Student student){
        return studentService.updateMobileNo(student);
    }

    //get student by given id

    //update --> email
    //           mobileNo
    //           age

    //delete student by given id
}
