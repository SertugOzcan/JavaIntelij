package com.cardealer.util;

import com.cardealer.entity.Car;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    /*
            readFile(String path) diye bir metot yazalım
            bu metot dosya okuma işlemi yapcak okuduğu verileri listeŞeklinde geri döenecek
            src//car.csv

            sonuçta elimde Car listesi olacak şşekilde bir metot yazalım
     */

    public static List<String> readFile(String path){
        List<String> data = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String satir ;
            while ((satir = reader.readLine()) != null){
                data.add(satir);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static List<Car> getCarList(List<String> data){
        List<Car> cars = new ArrayList<>();

        for (String stringCar : data) {
            cars.add(convertToCar(stringCar.split(",")));
        }
        return cars;
    }
    public static Car convertToCar(String[] array) {
        Car car = new Car(Integer.parseInt(array[0]),array[1],array[2],array[3],Integer.parseInt(array[4]));
        return car;
    }



}
