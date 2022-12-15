package com.vdoichev.myshop.repository.impl;

import com.vdoichev.myshop.entity.Product;
import com.vdoichev.myshop.repository.ProductRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> myFindProductsByNameRegex(String nameFilter) {
        CriteriaBuilder productBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> productQuery = productBuilder.createQuery(Product.class);
        Root<Product> productRoot = productQuery.from(Product.class);

        Expression<String> patternExpression = productBuilder.function(
                "REGEXP_LIKE",
                String.class,
                productRoot.get("name"),
                productBuilder.literal(nameFilter)
        );

        productQuery.select(productRoot).where(productBuilder.notEqual(
                patternExpression,
                productBuilder.literal(true))
        );

        return entityManager.createQuery(productQuery).getResultList();
    }
}
