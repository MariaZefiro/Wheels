package org.example.controller;

import com.google.gson.Gson;
import org.example.model.Costumer;
import org.example.repository.CostumerRepository;
import spark.Request;
import spark.Response;

public class CostumerController {

    CostumerRepository costumerRepository = new CostumerRepository();

    // Listar
    public String getAll(Request req, Response res) {
        var costumerList = costumerRepository.list();
        var gson = new Gson();
        var costumerListStr = gson.toJson(costumerList);
        return costumerListStr;
    }

    // Inserir
    public Costumer insert(
            String name, String address, String tel
    ) {
        Costumer costumer = new Costumer(name, address, tel);
        costumerRepository.create(costumer);
        return costumer;
    }
}
