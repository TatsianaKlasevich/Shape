package com.klasevich.quadrangle.creator;

import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.entity.QuadrangleProperty;
import com.klasevich.quadrangle.observer.QuadrangleEvent;
import com.klasevich.quadrangle.util.generator.QuadrangleIdGenerator;
import com.klasevich.quadrangle.warehouse.QuadranglePropertyWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class QuadrangleCreator {
    private static final Logger logger = LogManager.getLogger();

    public void createQuadrangle(Optional<Quadrangle> quadrangle) {
        QuadrangleRepository repository = QuadrangleRepository.getInstance();
        QuadranglePropertyWarehouse warehouse = QuadranglePropertyWarehouse.getInstance();
        QuadrangleProperty property = new QuadrangleProperty();

        if (quadrangle.isPresent()) {
            Quadrangle quadrangleResult = quadrangle.get();
            int id = QuadrangleIdGenerator.getCurrentId();
            warehouse.put(id, property);
            repository.add(quadrangleResult);
            QuadrangleEvent event = new QuadrangleEvent(quadrangleResult);
            logger.debug("quadrangleResult {}", quadrangleResult);
        }
    }
}
