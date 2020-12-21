package com.klasevich.quadrangle.observer.impl;

import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.entity.QuadrangleProperty;
import com.klasevich.quadrangle.observer.Observer;
import com.klasevich.quadrangle.observer.QuadrangleEvent;
import com.klasevich.quadrangle.service.QuadrangleService;
import com.klasevich.quadrangle.warehouse.QuadranglePropertyWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleObserverImpl implements Observer {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public void parameterChanged(QuadrangleEvent event) {
        Quadrangle quadrangle = event.getSource();
        QuadrangleService service = new QuadrangleService();
        QuadranglePropertyWarehouse warehouse = QuadranglePropertyWarehouse.getInstance();

        double perimeter = service.findPerimeter(quadrangle);
        double square = service.findArea(quadrangle);
        int id = quadrangle.getShapeId();
        logger.debug("perimeter {}, square{} of quadrangle with {} id", perimeter, square, id);

        QuadrangleProperty property = new QuadrangleProperty(perimeter, square);
        warehouse.put(id, property);
    }
}
