package com.shoppingapp.orderservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}


