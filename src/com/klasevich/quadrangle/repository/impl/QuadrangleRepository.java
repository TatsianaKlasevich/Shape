package com.klasevich.quadrangle.repository.impl;

import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.repository.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrangleRepository implements Repository<Quadrangle> {
    private static final Logger logger = LogManager.getLogger();
    private static QuadrangleRepository instance;
    private List<Quadrangle> quadrangles;

    private QuadrangleRepository() {
        quadrangles = new ArrayList<>();
        logger.info("Quadrangle has been created");
    }

    public static QuadrangleRepository getInstance() {
        if (instance == null) {
            instance = new QuadrangleRepository();
        }
        return instance;
    }

    public void add(Quadrangle quadrangle) {
        if (quadrangle != null) {
            quadrangles.add(quadrangle);
        }
        logger.debug("quadrangle {} has been added", quadrangle);
    }

    public void remove(int index) {
        if (index >= quadrangles.size()) {
            logger.error("quadrangle with index {} doesn't exist", index);
        }
        quadrangles.remove(index);
        logger.debug("quadrangle with index {} has been removed", index);
    }

    @Override
    public int size() {
        return quadrangles.size();
    }

    @Override
    public Quadrangle get(int index) {
        return quadrangles.get(index);
    }

    public List<Quadrangle> query(Specification<Quadrangle> specification) {
        List<Quadrangle> result = quadrangles.stream().filter(specification::specify).collect(Collectors.toList());
        logger.debug("query is completed, result is {}", result);
        return result;
    }

    @Override
    public List<Quadrangle> sort(Comparator<Quadrangle> comparator) {
        List<Quadrangle> result = new ArrayList<>(quadrangles);
        result.sort(comparator);
        logger.debug("sort is completed, result is {}", result);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuadrangleRepository{");
        sb.append("quadrangles=").append(quadrangles);
        sb.append('}');
        return sb.toString();
    }
}