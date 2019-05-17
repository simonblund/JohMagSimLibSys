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
        Copy copy = new Copy(0, 0, 0);


        //testLoan
        LocalDate today = LocalDate.now();
        loan = new Loan();
        loan.setUserID(user.getId());
        loan.setDate(LocalDate.now());
        loan.setExpectedReturnDate(today.plusDays(14));
        loan.setCopyID(copy.getItemID());

        return loan;

    }

    //Tests that insertLoan inserted loan properly. Doesnt work for loanID and userID

    @Test
    public void insertLoan(){
        Loan loan = testLoan();
        LoanDAO.insertLoan(loan);

        ArrayList loanResult = LoanDAO.findAllLoans();

        Loan dbLoan = (Loan) loanResult.get(0);

        for (Object loanElement : loanResult) {
            System.out.println(loanElement);
        }

        assertEquals(loan.getCopyID(), dbLoan.getCopyID());

    }

    @Test
    public void testUpdateReturnDate(){
        Loan loan = testLoan();
        loan.setLoanID(5);

        LoanDAO.updateReturnDateOnLoan(loan);

        ArrayList loanResult = LoanDAO.findAllLoans();

        Loan dbLoan = (Loan) loanResult.get(0);

        for (Object loanElement : loanResult) {
            System.out.println(loanElement);
        }

        assertEquals(loan.getActualReturnDate(), dbLoan.getActualReturnDate());
    }

    @Test
    public void testUpdateExpectedReturnDate(){
        Loan loan = testLoan();
        loan.setLoanID(2);

        LoanDAO.updateExpectedReturnDateOnLoan(loan, "2019-01-02");

        ArrayList loanResult = LoanDAO.findAllLoans();

        Loan dbLoan = (Loan) loanResult.get(0);

        for (Object loanElement : loanResult) {
            System.out.println(loanElement);
        }

        assertEquals(loan.getExpectedReturnDate(), dbLoan.getExpectedReturnDate());
    }



}
