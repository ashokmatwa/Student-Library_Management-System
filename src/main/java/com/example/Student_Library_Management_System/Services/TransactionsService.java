package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Enums.TransactionsStatus;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Transactions;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import com.example.Student_Library_Management_System.Repositories.CardRepository;
import com.example.Student_Library_Management_System.Repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionsService {

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{

        int bookId = issueBookRequestDto.getBookId();
        int cardId = issueBookRequestDto.getCardId();

        //Get the Book Entity and Card Entity ??? Why do we need this
        //We are this bcz we want to set the Transaction attributes...
        Book book =  bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        //Final goal is to make a transaction Entity, set its attribute and save it.
        Transactions transaction = new Transactions();

        //Setting the attributes
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setIssued(true);
        //transaction.setTransactionsStatus(TransactionsStatus.PENDING);
//        transaction.setTransactionId(UUID.randomUUID().toString());

        //Check for validations
        if(book == null || book.isIssued() == true){
            transaction.setTransactionsStatus(TransactionsStatus.FAILED);
            transactionsRepository.save(transaction);
            throw new Exception("Book is not available");
        }

        if(card == null || card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionsStatus(TransactionsStatus.FAILED);
            transactionsRepository.save(transaction);
            throw new Exception("Card is not valid");
        }

        //We have reached a success case now.
        transaction.setTransactionsStatus(TransactionsStatus.SUCCESS);

        //book attributes
        //Btw the book and transaction : bidirectional
        book.setIssued(true);
        List<Transactions> transactionsListOfBook = book.getTransactionsList();
        transactionsListOfBook.add(transaction);
        book.setTransactionsList(transactionsListOfBook);

        //card for book
        List<Book> bookList = card.getBooksIssued();
        bookList.add(book);
        card.setBooksIssued(bookList);

        //Card and the Transaction : bidirectional (parent class)
        List<Transactions> transactionsListForCard = card.getTransactionsList();
        transactionsListForCard.add(transaction);
        card.setTransactionsList(transactionsListForCard);


        //automatically by cascading : book and transaction will be saved.
        //Saving the parent
        cardRepository.save(card);

        return "Book issued successfully";
    }

    public String getTransactions(int bookId,int cardId){

        List<Transactions> transactionsList = transactionsRepository.getTransactionsForBookAndCard(bookId,cardId);

        String transactionId = transactionsList.get(0).getTransactionId();

        return transactionId;
    }
}
