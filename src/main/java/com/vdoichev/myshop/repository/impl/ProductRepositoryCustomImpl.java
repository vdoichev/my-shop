package com.vdoichev.myshop.repository.impl;

import com.vdoichev.myshop.entity.Product;
import com.vdoichev.myshop.repository.ProductRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> myFindProductsByNameRegex(String nameFilter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> productQuery = cb.createQuery(Product.class);
        Root<Product> productRoot = productQuery.from(Product.class);

        productQuery.select(productRoot).where(cb.like(productRoot.get("name"), nameFilter));
        return entityManager.createQuery(productQuery)
                .getResultList();
    }
}
