package com.klasevich.quadrangle.repository.specification.impl;

import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.repository.specification.Specification;
import com.klasevich.quadrangle.service.QuadrangleService;

public class IsConvexQuadrangleSpecification implements Specification<Quadrangle> {

    @Override
    public boolean specify(Quadrangle quadrangle) {
        QuadrangleService service = new QuadrangleService();
        boolean result = service.isConvexQuadrangle(quadrangle);
        return result;
    }
}

