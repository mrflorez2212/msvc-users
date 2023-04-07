package com.marco.springcloud.msvc.users.msvcusers.service;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.PurchaseOrder;

import java.util.List;


public interface IOrderService
{
    PurchaseOrder saveOrder( PurchaseOrder order );

    PurchaseOrder getOrderById( Long id );

    PurchaseOrder updateOrder( PurchaseOrder order );

    void deleteOrder( Long id );

    List<PurchaseOrder> getAllOrders();

}
