package com.project.ecom_proj.Repository;

import com.project.ecom_proj.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query
    public List<Product> searchProducts(String keyword);
}
