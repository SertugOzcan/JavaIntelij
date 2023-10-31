package com.atmbanking.repository;

import com.atmbanking.entity.Account;
import com.atmbanking.entity.TransferDekont;
import com.atmbanking.entity.User;
import com.atmbanking.util.DbConnection;
import com.atmbanking.util.RandomGenerateAccountNo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    /**
     *
     * @author berkin.yardimci
     * params: user
     * return : String(account No)
     *
     * --15:57--
     */
    public String createAccount(User user)  {
        String query = "insert into accounts (user_id, account_no) values(?,?)";
        PreparedStatement preparedStatement = null;

        Account account = Account.builder()
                .userId(user.getId())
                .accountNo(RandomGenerateAccountNo.generateAccountNo())
                .build();
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setInt(1,account.getUserId());
            preparedStatement.setString(2, account.getAccountNo());
            if(preparedStatement.executeUpdate() > 0){
                return account.getAccountNo();
            }else {
                throw new RuntimeException("Hesap oluşturmai işlemnide HATA!!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> getAccountsByEmail(String email){
        List<Account> accounts = new ArrayList<>();
        String query = "select a.* from users as u inner join accounts as a on a.user_id = u.id where u.email = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                double balance = resultSet.getDouble("balance");
                String accountNo = resultSet.getString("account_no");
                int id = resultSet.getInt("id");
                Date creationDate = resultSet.getDate("creation_date");

                Account account = Account.builder()
                        .accountNo(accountNo)
                        .id(id)
                        .balance(balance)
                        .caretionDate(creationDate)
                        .build();
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    public TransferDekont transferMoney(int amount, String accountNo, User user){
        String query = "update accounts set balance = balance + ? where account_no = ? ";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setDouble(1,amount);
            preparedStatement.setString(2,accountNo);
            preparedStatement.executeUpdate();

            String receiverName = findUserNameByAccountNo(accountNo);

            TransferDekont transferDekont = TransferDekont.builder()
                    .transactionDate(new java.util.Date())
                    .sendAmountTotal(amount)
                    .senderName(user.getName())
                    .receiverName(receiverName)
                    .build();
            return transferDekont;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public String findUserNameByAccountNo(String accountNo){
        String query = "select users.name from users inner join accounts on users.id = accounts.user_id where account_no = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1,accountNo);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
