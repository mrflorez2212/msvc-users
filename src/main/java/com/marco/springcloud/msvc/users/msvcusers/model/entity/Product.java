package com.marco.springcloud.msvc.users.msvcusers.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String category;

    private Double price;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {
                      CascadeType.PERSIST,
                      CascadeType.MERGE
                },
                mappedBy = "products")
    @JsonIgnore
    private Set<PurchaseOrder> purchaseOrders;



}
