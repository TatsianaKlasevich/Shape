package com.klasevich.quadrangle.warehouse;

import com.klasevich.quadrangle.entity.QuadrangleProperty;

import java.util.HashMap;
import java.util.Map;

public class QuadranglePropertyWarehouse {
    private static final QuadranglePropertyWarehouse instance = new QuadranglePropertyWarehouse();
    private Map<Integer, QuadrangleProperty> storage;

    private QuadranglePropertyWarehouse() {
        storage = new HashMap<>();
    }

    public static QuadranglePropertyWarehouse getInstance(){
        return instance;
    }

    public QuadrangleProperty getQuadrangleProperty(Integer id) {
        return storage.get(id);
    }

    public QuadrangleProperty get (int id){
        QuadrangleProperty value = null;
        for (Map.Entry<Integer,QuadrangleProperty> pair: storage.entrySet()) {
            if (pair.getKey()==id){
              value  = pair.getValue();
            }
        }
        return value;
    }

    public QuadrangleProperty put(Integer id, QuadrangleProperty property) {
        return storage.put(id, property);
    }

    public void remove(Integer id) {
        storage.remove(id);
    }

    public int size() {
        return storage.size();
    }
}
