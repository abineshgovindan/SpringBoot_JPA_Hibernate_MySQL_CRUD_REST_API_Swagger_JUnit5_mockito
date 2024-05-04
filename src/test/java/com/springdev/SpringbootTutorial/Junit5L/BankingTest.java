package com.springdev.SpringbootTutorial.Junit5L;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BankingTest {
    @Autowired
    Banking bank;
    @BeforeEach
    void init(){
        bank = new Banking();
    }



    @Test
    @DisplayName("Appling For Loan TEST")
    @Tag("loan")
    void itShouldCheckApplyingLoan() throws BankException {
        bank.setCurrentBalance(100000);
        double loanAmount = 450000;
        double res = bank.applyForLoan(loanAmount);
        assertEquals(loanAmount, res);
    }

    @Test
    @DisplayName("Check Current Balance")
    void getCurrentBalance() throws BankException {
        double balance = 100000;
        bank.setCurrentBalance(balance);
        assertEquals(balance, bank.getCurrentBalance());


    }
    @Test
    @DisplayName("Check Invalid input Current Balance")
    @Tag("negativeBalance")
    void CheckInvalidCurrentBalance() throws BankException {
        double balance = -100000;

        BankException exception = assertThrows(BankException.class, ()->{
            bank.setCurrentBalance(balance);
        });
        assertEquals("balance should not be zero", exception.getMessage());


    }

    @Test
    void setCurrentBalance() {
    }

    @Test
    void getLoanAmount() {
    }

    @Test
    void setLoanAmount() {
    }

    @Test
    void getMonthlyIntest() {
    }

    @Test
    void payMonthlyIntest() {
    }
    @AfterEach
    void tearDown(){
        bank = null;
    }
}