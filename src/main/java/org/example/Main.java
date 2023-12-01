package org.example;

import org.example.controller.BikeController;
import org.example.controller.CostumerController;
import org.example.controller.HireController;
import org.example.model.Bike;
import org.example.model.Costumer;
import org.example.model.Hire;

import static spark.Spark.*;

public class Main {
    static BikeController bikeController = new BikeController();
    static CostumerController costumerController = new CostumerController();
    static HireController hireController = new HireController();

    public static void main(String[] args) {
        //inserirDadosDeTestes();
        //inserirDadosDeClientesDeTestes();
        //inserirDadosDeAlugueisDeTestes();
        port(8080);

        // Solicitar a lista de bikes
        get("/bike", (req, res) -> bikeController.getAll(req, res));
        post("/bike", (req, res) -> bikeController.insert(req, res));
        get("/costumer", (req, res) -> costumerController.getAll(req, res));
        get("/hire", (req, res) -> hireController.getAll(req, res));
        System.out.println("Executando...");
    }

    //private static BikeController inserirDadosDeTestes() {
    //    String available = "disponível";
    //   String type = "Infantil";
    //    int size = 1;
    //   String make = "Marca";
    //   String model = "Modelo XPTO";
    //    double dailyHireRate = 2.00;
    //   double deposit = 10.00;

    //  bikeController.insert(available, type, size, make, model, dailyHireRate, deposit);
    //  bikeController.insert(available, type, size, make, model, dailyHireRate, deposit);
    //  bikeController.insert(available, type, size, make, model, dailyHireRate, deposit);
    //  Bike bike = bikeController.insert(available, type, size, make, model, dailyHireRate, deposit);
    //   return bikeController;
    //}

    private static CostumerController inserirDadosDeClientesDeTestes() {
        String name = "Joaquim";
        String address = "Rua dos Bobos, 0";
        String tel = "899034838";

        costumerController.insert(name, address, tel);
        costumerController.insert(name, address, tel);
        costumerController.insert(name, address, tel);
        Costumer costumer = costumerController.insert(name, address, tel);
        return costumerController;
    }

    private static HireController inserirDadosDeAlugueisDeTestes() {
        String startDate = "1";
        int numberDays = 10;
        String dateReturned = "20";
        double latenessDeduction = 1.0;
        double damageDeduction = 0.5;
        Costumer costumer = new Costumer("Julio","Estrada","219987561");
        Bike bike = new Bike("disponível", "montanha", 5, "Honda", "XPTO", 2.0, 10.0);

        hireController.insert(startDate, numberDays, dateReturned, latenessDeduction, damageDeduction, costumer, bike);
        hireController.insert(startDate, numberDays, dateReturned, latenessDeduction, damageDeduction, costumer, bike);
        hireController.insert(startDate, numberDays, dateReturned, latenessDeduction, damageDeduction, costumer, bike);
        Hire hire = hireController.insert(startDate, numberDays, dateReturned, latenessDeduction, damageDeduction, costumer, bike);
        return hireController;
    }
}