package com.example.repository;

import com.example.entity.Person;
import com.example.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonRepository {

    public void register(Person person){
        String sql = "INSERT INTO persons(first_name,last_name,email) values(?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getFirstName());
            preparedStatement.setString(2,person.getLastName());
            preparedStatement.setString(3,person.getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Bağlantı Hatası "  + e);
        }finally {
               JDBCHelper.closeConnection(connection);
               JDBCHelper.closePreparedStatement(preparedStatement);
        }
    }
}
