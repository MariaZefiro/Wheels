package org.example.controller;

import com.google.gson.Gson;
import org.example.model.Bike;
import org.example.repository.BikeRepository;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

public class BikeController {

    BikeRepository bikeRepository = new BikeRepository();

    Gson gson = new Gson();
    // listar
    public String getAll(Request req, Response res) {
        var bikeList = bikeRepository.list();
        var gson = new Gson();
        var bikeListStr = gson.toJson(bikeList);
        return bikeListStr;
    }
    //Inserir fazendo POST através do VSC (Client REST) GET http... e POST http...
    public String insert(Request req, Response res){
        String body = req.body();
        Bike newBike = gson.fromJson(body, Bike.class);
        Bike bike = bikeRepository.create(newBike);
        var bikeStr = gson.toJson(bike);
        return bikeStr;
    }

    // inserir pelo método na Main
    //public Bike insert(
    //        String available, String type,
    //       int size, String make,
    //       String model, double dailyHireRate,
    //        double deposit
    //) {
    //    Bike bike = new Bike(
    //            available, type,
    //            size, make,
    //            model, dailyHireRate,
    //            deposit
    //    );
    //    return bikeRepository.create(bike);
    //}

    // exibir

    // atualizar

    // remover

}
