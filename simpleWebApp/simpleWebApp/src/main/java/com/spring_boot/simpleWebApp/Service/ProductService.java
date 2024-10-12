package com.spring_boot.simpleWebApp.Service;

import com.spring_boot.simpleWebApp.Model.Product;
import com.spring_boot.simpleWebApp.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products= new ArrayList<>(Arrays.asList(new Product(101,"Iphone",50000),new Product(102,"Canon Camera",70000),new Product(103,"shure mic",200000)));

    public List<Product> getProducts(){
        return repo.findAll();
    }


    public Product getProduct(int prodId) {
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public void uptadeProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId){
        repo.deleteById(prodId);
    }
}
