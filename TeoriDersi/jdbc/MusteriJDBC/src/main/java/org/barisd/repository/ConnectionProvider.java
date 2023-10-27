package org.barisd.repository;

import java.sql.*;
import java.util.Optional;

public class ConnectionProvider {
    private final String vtAd="Java12SatisVT";
    private final String connectionAdres="jdbc:postgresql://localhost:5432/"+vtAd;
    private final String username="postgres";
    private final String password="1234";
    private Connection connection;
    private boolean openConnection(){
        try {
            connection= DriverManager.getConnection(connectionAdres,username,password);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    private void closeConnection(){
        try {
            if(!connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("closeConnection() metodunda hata:"+e);
        }
    }
    public boolean myExecuteUpdate(String Query){
        if(openConnection()){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                preparedStatement.executeUpdate();//INSERT,DELETE,UPDATE
                closeConnection();
                return true;
            } catch (SQLException e) {
                closeConnection();
            }
        }
        return false;
    }
    public Optional<ResultSet> getAllData(String Query){
        if(openConnection()){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                ResultSet resultSet = preparedStatement.executeQuery(); //SELECT
                closeConnection();
                return Optional.of(resultSet);
            } catch (SQLException e) {
                closeConnection();
            }
        }
        return Optional.empty();
    }


}
