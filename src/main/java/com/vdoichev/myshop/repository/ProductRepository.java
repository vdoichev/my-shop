package com.vdoichev.myshop.repository;

import com.vdoichev.myshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByOrderByName();

    @Query(nativeQuery=true, value="SELECT * FROM product WHERE name regexp ?1")
    List<Product> findProductsByNameRegex(String nameFilter);
}
