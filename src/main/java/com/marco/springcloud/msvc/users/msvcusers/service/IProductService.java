package com.marco.springcloud.msvc.users.msvcusers.service;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.Product;

import java.util.List;


public interface IProductService
{

    Product saveProduct( Product product );

    Product getProductById( Long id );

    Product getProductByName( String name );

    Product updateProduct( Product product );

    void deleteProduct( Long id );

    List<Product> getAllProducts();

    List<Product> getProductByCategoryAndPrice( String category, Double price );

}
