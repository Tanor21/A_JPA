package com.norcorp.dao;

import com.norcorp.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements EntityRepository<Product>{
    @PersistenceContext
    private EntityManager em;
    @Override
    public Product save(Product p) {
        em.persist(p);
        return p;
    }

    @Override
    public List<Product> findAll() {
        Query req = em.createQuery("select p from Product p");
        return req.getResultList();
    }

    @Override
    public List<Product> findByDesignation(String mc) {
        Query req = em.createQuery("select p from Product p where p.designation like : x");
        req.setParameter("x", mc);
        return req.getResultList();
    }

    @Override
    public Product findOne(Long id) {
        Product p = em.find(Product.class, id);
        return p;
    }

    @Override
    public Product update(Product p) {
        em.merge(p);
        return p;
    }

    @Override
    public void delete(Long id) {
        Product p = em.find(Product.class, id);
        em.remove(p);
    }
}
