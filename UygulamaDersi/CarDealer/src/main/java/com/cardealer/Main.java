package com.cardealer;

import com.cardealer.repository.CarRepository;
import com.cardealer.util.Constant;
import com.cardealer.util.DbConnection;
import com.cardealer.util.FileUtils;

import java.sql.SQLException;

public class Main {

    /*
        1- Database oluşturmamız lazım +
        2- entityleri oluşturmak +
        3- Dosya okuma işlemi için gerekli yapıyı oluşturcaz
        4- Singleton bir connection oluşturalım
        5- verileri database yacaz
        6- Interface oluşturalım
     */

    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        try {
            DbConnection.getInstance().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        carRepository.saveAll(FileUtils.getCarList(FileUtils.readFile(Constant.CAR_FILE)));
    }
}