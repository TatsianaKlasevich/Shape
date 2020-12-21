package com.klasevich.quadrangle.repository.specification;

import com.klasevich.quadrangle.entity.AbstractShape;

public interface Specification<T extends AbstractShape> {
    boolean specify(T t);
}
