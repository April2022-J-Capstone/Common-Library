package com.smoothstack.common.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_status", length = 45)
    private String orderStatus;

    @Column(name = "restaurant_notes", length = 250)
    private String restaurantNotes;

    @Column(name = "driver_notes", length = 250)
    private String driverNotes;

    @Column(name = "sub_total")
    private Double subTotal;

    @Column(name = "delivery_fee")
    private Double deliveryFee;

    @Column(name = "tax")
    private Double tax;

    @Column(name = "tip")
    private Double tip;

    @Column(name = "total")
    private Double total;

    @Column(name = "time_created")
    private LocalDateTime timeCreated;

    @Column(name = "scheduled_for")
    private LocalDateTime scheduledFor;

    @Column(name = "net_loyalty")
    private Integer netLoyalty;

    @ManyToMany
    @JoinTable(name = "payment",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_id"))
    private List<Card> cards;

    @ManyToOne
    @JoinTable(name = "order_driver",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id"))
    private User driver;

    @ManyToMany
    @JoinTable(name = "order_restaurant",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id"))
    private List<Restaurant> restaurants;

    @ManyToMany
    @JoinTable(name = "order_discount",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id"))
    private List<Discount> discounts;

    @ManyToOne
    @JoinTable(name = "customer_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private User customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderItem> orderItems;
}