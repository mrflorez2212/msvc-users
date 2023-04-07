package com.marco.springcloud.msvc.users.msvcusers.controller;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.Product;
import com.marco.springcloud.msvc.users.msvcusers.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping( value = "/products" )
@AllArgsConstructor
@Slf4j
public class ProductController
{

    IProductService productService;

    @GetMapping( "/{id}" )
    public ResponseEntity<Product> findById( @PathVariable final Long id)
    {
        return ResponseEntity.ok( productService.getProductById( id ) );
    }

    @PostMapping( )
    public ResponseEntity<Product> saveProduct( @RequestBody final Product product )
    {
        return ResponseEntity.ok( productService.saveProduct( product ) );
    }

    @GetMapping( "/getProductByCategoryAndPrice" )
    public ResponseEntity<List<Product>> getProductByCategoryAndPrice( @RequestParam final String category,  @RequestParam final Double price)
    {
        return ResponseEntity.ok( productService.getProductByCategoryAndPrice( category, price ));
    }

}
