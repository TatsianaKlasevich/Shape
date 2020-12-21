package com.klasevich.quadrangle.repository;

import com.klasevich.quadrangle.entity.AbstractShape;
import com.klasevich.quadrangle.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T extends AbstractShape> {

    void add(T shape);

    void remove(int index);

    int size();

    T get(int index);

    List<T> query(Specification<T> specification);

    List<T> sort(Comparator<T> comparator);
}
