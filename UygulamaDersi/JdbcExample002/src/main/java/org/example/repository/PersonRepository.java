//package org.example.repository;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.example.entity.Person;
//public class PersonRepository {
//
//
//
//public class PersonRepository {
//
//    public void register(Person person) {
//        public void register(Person person){
//            String sql = "INSERT INTO persons(first_name,last_name,email) values(?,?,?)";
//            Connection connection = null;
//            PreparedStatement preparedStatement = null;
//
//            try {
//                connection = JDBCHelper.getConnection();
//                preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setString(1,person.getFirstName());
//                preparedStatement.setString(2,person.getLastName());
//                preparedStatement.setString(3,person.getEmail());
//                preparedStatement.executeUpdate();
//
//            } catch (SQLException e) {
//                throw new RuntimeException("Bağlantı Hatası "  + e);
//            }finally {
//                JDBCHelper.closeConnection(connection);
//                JDBCHelper.closePreparedStatement(preparedStatement);
//            }
//        }
//    }
//
//    public List<Person> listPersons() {
//        List<Person> persons = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
//             Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM person")) {
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String firstName = rs.getString("firstName");
//                String lastName = rs.getString("lastName");
//                String email = rs.getString("email");
//                persons.add(new Person(id, firstName, lastName, email));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Error listing persons", e);
//        }
//        return persons;
//    }
//}
