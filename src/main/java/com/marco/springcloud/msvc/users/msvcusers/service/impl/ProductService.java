package com.marco.springcloud.msvc.users.msvcusers.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.marco.springcloud.msvc.users.msvcusers.kafka.ProduceProduct;
import com.marco.springcloud.msvc.users.msvcusers.model.entity.Product;
import com.marco.springcloud.msvc.users.msvcusers.repository.ProductRepository;
import com.marco.springcloud.msvc.users.msvcusers.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Profile( "dev" )
@AllArgsConstructor
@Slf4j
public class ProductService
      implements IProductService
{
    ProductRepository productRepository;

    ProduceProduct produceProduct;


    @Override
    public Product saveProduct( final Product product )
    {
        final Product productCreated = productRepository.save( product );
        try
        {
            produceProduct.sendMessage( productCreated );
        }
        catch ( JsonProcessingException e )
        {
            log.error( "Error while producing the message {}", e.getMessage() );
        }
        return productCreated;
    }


    @Override
    public Product getProductById( final Long id )
    {
        return productRepository.findById( id ).orElse( null );
    }

    @Override
    public List<Product> getProductByCategoryAndPrice( final String category, final Double price )
    {
        final List<Product> products = productRepository.findAll();
        return products.stream().filter( p -> p.getCategory().equalsIgnoreCase( category ) && p.getPrice() > price ).collect( Collectors.toList());
    }


    @Override
    public Product getProductByName( final String name )
    {
        return null;
    }


    @Override
    public Product updateProduct( final Product product )
    {
        return null;
    }


    @Override
    public void deleteProduct( final Long id )
    {

    }


    @Override
    public List<Product> getAllProducts()
    {
        return null;
    }
}
