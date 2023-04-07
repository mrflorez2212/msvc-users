package com.marco.springcloud.msvc.users.msvcusers.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotEmpty(message = "The order status couldn't be null")
    @Enumerated( EnumType.STRING)
    @Column(length = 20)
    private EOrderStatus orderStatus;

    private LocalDate orderDate;

    private LocalDate deliveryDate;

    @ManyToMany
    @JoinTable(
          name = "order_product_table",
          joinColumns = { @JoinColumn(name = "purchase_order_id") },
          inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private List<Product> products;

    @ManyToOne(cascade = { CascadeType.MERGE})
    @JoinColumn(name = "user")
    private User user;
}
