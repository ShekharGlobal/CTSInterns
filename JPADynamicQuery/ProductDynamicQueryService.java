package com.cts.service;

import com.cts.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDynamicQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> searchProducts(String name, String category, Double minPrice, Double maxPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        // SQL equivalent WHERE name LIKE '%apple%'
        if (name != null && !name.isEmpty()) {
            predicates.add(cb.like(product.get("name"), "%" + name + "%"));
        }

        // SQL equivalent WHERE category LIKE '%electronics%'
        if (category != null && !category.isEmpty()) {
            predicates.add(cb.like(product.get("category"), "%" + category + "%"));
        }

        // SQL equivalent WHERE price >= minPrice AND price <= maxPrice
        if (minPrice != null) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("price"), minPrice));
        }
        if (maxPrice != null) {
            predicates.add(cb.lessThanOrEqualTo(product.get("price"), maxPrice));
        }

        // Combine all predicates with AND logic
        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(cq).getResultList();
    }
}
