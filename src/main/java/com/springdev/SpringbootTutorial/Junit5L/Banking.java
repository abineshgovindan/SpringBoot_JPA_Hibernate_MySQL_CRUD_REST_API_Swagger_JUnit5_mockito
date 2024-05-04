package com.springdev.SpringbootTutorial.Junit5L;

public class Banking {
    private double currentBalance;
    private double loanAmount = 0;
    private double monthlyIntest;

    public Double applyForLoan(double val) throws BankException {

        double loanLimit = currentBalance * 7.5;
        if(loanLimit > val){
            setLoanAmount(val);
            return getLoanAmount();
        }else {
           return  loanLimit ;
        }

    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) throws BankException {
        if(currentBalance < 0){
            throw new BankException("balance should not be zero");
        }
        this.currentBalance = currentBalance;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyIntest(int months) throws BankException {
        if(loanAmount == 0){
            throw new BankException("First apply for loan");
        }
        if(!(months > 3 && months < 36)){
            throw new BankException("Enter months above 3 and below 36");
        }
        monthlyIntest = (loanAmount * 0.7) / months;
        return monthlyIntest;

    }

    public double PayMonthlyIntest() throws BankException {
       if(currentBalance < monthlyIntest){
           throw new BankException("your current balance is low");
       }
       currentBalance = currentBalance - monthlyIntest;
       double newLoanAmount = loanAmount - monthlyIntest;
       loanAmount = newLoanAmount;
       return loanAmount;
    }


    //RequestLoan cb > 7 times or else rejected and display this is ur max limit
    //calculate interst
    //give intest
    //balance loan am
    //pay intest

}
