package com.JohMagSim.Libr.modelTests;

import com.JohMagSim.Libr.model.*;
import org.junit.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;



public class LoanTest {

    private Loan loan;
    private Copy copy;

    public Loan testLoan(){

        //testUser
        User user = new User();
        user.setId(1);
        user.setEmail("test@test.ru");
        user.setFirstName("Elvan");
        user.setLastName("Elvansson");
        user.setPasswordHash("123123");
        user.setPasswordResetToken("123123123");

        //testCopy
        Copy copy = new Copy(1, "TestBok", 1234, "TestHylla", "Testklass", 3, false);

        //testLoan
        LocalDate today = LocalDate.now();
        loan = new Loan(1, LocalDate.now(), today.plusDays(14), copy.getItemID(), user.getId());

        return loan;

    }

    @Test
    public void insertLoan(){
        Loan loan = testLoan();
        LoanDAO.insertLoan(loan);

        assertTrue(true);

    }




}
