package com.jdbcexample;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        /*
                database oluşturalım school
                student tablomuz olcak --> name surname city
                Database bağlanıp bunu bi kontrol edelim bağlandık mı diye
                bağlandıysa consola bağlantı başrılı yazdıralım
                bağlanamda hata varsa Bağlantı Hatası:


                execute diye bir metot yazalım bu metot aldığı sql parametresini çalıştırsın connection
                execute(connection,sql)

                 createStudent(connection,student)
                 updateStudent(connection,student,id)

                 Student st1 = new Student(Mehmet,Yardımıc,İstanbul)
                 updateStudent(connection,st1,1)

                 findStudentbyCityName(connection, cityName)
                 //girdiğimiz şehirde yaşayan studentlar varsa onları yazdıarlım

                deleteById();


         */

        String url = "jdbc:postgresql://localhost:5432/school";
        String username = "postgres";
        String password = "1234";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Bağlantı Başarılı");

            String sql = "insert into student(name,surname,city) values('Mehmet','Yardımcı','Ankara')";
            //execute(connection,sql);
            //Student student = new Student("Ahmet","Yardımcı","Ankara");
            //Student student = new Student("Ahmet","Yardımcı","İzmir");
            //createStudent(connection,student);
            //updateStudent(connection,student,2);

            //indByStudentCityName(connection,"ank");
            deleteById(connection,15);

        } catch (SQLException e) {
            System.out.println("Bağlantı Hatası "+ e);
        }finally {
            try {
                if(connection != null){
                    connection.close();
                    System.out.println("Kapatma işlemi Başarılı");
                }
            } catch (SQLException e) {
                System.out.println("Kapatma Hatası");
            }
        }
    }

    public static void createStudent(Connection connection, Student student){
        String sqlQuery = "Insert into student(name,surname,city) values(?,?,?)";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);
            prepareStatement.setString(1,student.getName());
            prepareStatement.setString(2,student.getSurname());
            prepareStatement.setString(3,student.getCity());

            prepareStatement.executeUpdate();
            System.out.println("Kayıt işlemi Başarılı");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateStudent(Connection connection, Student student,int id){
        String sqlQuery = "update student set name=? , surname=? , city=? where id = ?";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);
            prepareStatement.setString(1,student.getName());
            prepareStatement.setString(2,student.getSurname());
            prepareStatement.setString(3,student.getCity());
            prepareStatement.setInt(4,id);

            prepareStatement.executeUpdate();
            System.out.println("Kayıt işlemi Başarılı");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void findByStudentCityName(Connection connection, String cityName){
        String sql = "select * from student where city ilike ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"%"+cityName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString(2);
                String surname = resultSet.getString("surname");
                String city = resultSet.getString(4);

                System.out.println("Name: " + name + " Surname " + surname + " City " + city);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteById(Connection connection, int id){
        String querySql = "delete from student where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setInt(1,id);
            int affectedRow = preparedStatement.executeUpdate();
            if(affectedRow > 0){
                System.out.println("Silme işlemi Başarılı");
            }else{
                System.out.println("Böyle id li biri yoktur");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void execute(Connection connection , String sql){
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("İşlem Başarılı");
        } catch (SQLException e) {
            System.out.println("Sorgu Hatası");
        }
    }
}