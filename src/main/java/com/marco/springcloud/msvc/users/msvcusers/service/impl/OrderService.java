package com.marco.springcloud.msvc.users.msvcusers.service.impl;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.EOrderStatus;
import com.marco.springcloud.msvc.users.msvcusers.model.entity.PurchaseOrder;
import com.marco.springcloud.msvc.users.msvcusers.repository.PurchaseOrderRepository;
import com.marco.springcloud.msvc.users.msvcusers.service.IOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class OrderService implements IOrderService
{

    public PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public PurchaseOrder saveOrder( final PurchaseOrder order )
    {
        return purchaseOrderRepository.save( order );
    }


    @Override
    public PurchaseOrder getOrderById( final Long id )
    {
        //return purchaseOrderRepository.getById( id );
        return PurchaseOrder.builder().orderDate( LocalDate.now() ).deliveryDate( LocalDate.now() ).orderStatus( EOrderStatus.CANCELED ).build();
    }


    @Override
    public PurchaseOrder updateOrder( final PurchaseOrder order )
    {
        return purchaseOrderRepository.save( order );
    }


    @Override
    public void deleteOrder( final Long id )
    {

    }


    @Override
    public List<PurchaseOrder> getAllOrders()
    {
        return null;
    }
}
