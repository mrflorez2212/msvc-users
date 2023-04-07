package com.marco.springcloud.msvc.users.msvcusers.repository;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{

    Product findByName( String name );

    Product findByDescription( String description );

}
