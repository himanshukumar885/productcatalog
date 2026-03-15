package com.myshop.productcatalog.repository;

import com.myshop.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository
extends JpaRepository<Product, Long>
{
    
}