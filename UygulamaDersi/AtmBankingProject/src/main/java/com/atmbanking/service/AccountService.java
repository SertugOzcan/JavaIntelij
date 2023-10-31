package com.atmbanking.service;

import com.atmbanking.entity.Account;
import com.atmbanking.entity.TransferDekont;
import com.atmbanking.entity.User;
import com.atmbanking.repository.AccountRepository;

import java.util.List;

public class AccountService {


    private final AccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    public void createAccount(User user){
        String accountNo = accountRepository.createAccount(user);
        System.out.println("Hesabınız Oluşturuldu Hesap No: " + accountNo);
    }

    public void getAccountByEmail(String email){
        List<Account> accountList = accountRepository.getAccountsByEmail(email);
        //accountList.forEach(account -> System.out.println("Hesap NO: "+ account.getAccountNo() + " Bakiyeniz: " + account.getBalance()));
        System.out.println(accountList);
    }

    public void transfer(int amount, String accountNo, User user){
        TransferDekont transferDekont =  accountRepository.transferMoney(amount,accountNo,user);
        System.out.println(transferDekont);
    }
}
