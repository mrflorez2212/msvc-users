package com.marco.springcloud.msvc.users.msvcusers.repository;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long>
{


}
