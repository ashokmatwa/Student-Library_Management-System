package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionsService transactionsService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){
        try{
            return transactionsService.issueBook(issueBookRequestDto);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/getTxnInfo")
    public String getTransactionEntry(@RequestParam("bookId")Integer bookId,
                                      @RequestParam("cardId")Integer cardId){

        return transactionsService.getTransactions(bookId,cardId);
    }
}
