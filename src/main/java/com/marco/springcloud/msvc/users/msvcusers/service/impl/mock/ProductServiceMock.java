package com.marco.springcloud.msvc.users.msvcusers.service.impl.mock;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.Product;
import com.marco.springcloud.msvc.users.msvcusers.service.IProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Profile( "mock" )
public class ProductServiceMock implements IProductService
{
    @Override
    public Product saveProduct( final Product product )
    {
       return Product.builder().id(1L).name("Product 1").build();
    }


    @Override
    public Product getProductById( final Long id )
    {
        return Product.builder().id(1L).name("Product 1").build();
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


    @Override
    public List<Product> getProductByCategoryAndPrice( final String category,
                                                       final Double price )
    {
        return null;
    }
}
