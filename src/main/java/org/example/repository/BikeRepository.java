package org.example.repository;

import org.example.model.Bike;

import java.util.ArrayList;
import java.util.List;

public class BikeRepository {
    private ArrayList<Bike> bikes = new ArrayList<>();
    private long lastId = 1;

    // Lista
    public ArrayList<Bike> list() {
        return bikes;
    }

    // Criar
    public Bike create(Bike bike) {
        bike.setId(lastId++);
        bikes.add(bike);
        return bike;
    }


    // Ler

    // Atualizar

    // Excluir
}
