package com.marco.springcloud.msvc.users.msvcusers.controller;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.PurchaseOrder;
import com.marco.springcloud.msvc.users.msvcusers.service.IOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping( value = "/orders" )
@Slf4j
@AllArgsConstructor
public class OrderController
{
    private IOrderService orderService;

    @PostMapping( )
    public PurchaseOrder saveOrder( @RequestBody final PurchaseOrder order, final Principal principal ){
        log.info( "Principal: " + principal.getName() );
        return orderService.saveOrder( order );
    }
    @GetMapping( "/{id}" )
    public PurchaseOrder getOrderById( @PathVariable final Long id ){
        return orderService.getOrderById( id );
    }

    @GetMapping( )
    public List<PurchaseOrder> getAllOrders(){
        return orderService.getAllOrders();
    }

}
