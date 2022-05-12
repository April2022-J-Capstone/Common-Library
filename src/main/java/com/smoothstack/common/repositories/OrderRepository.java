package com.smoothstack.common.repositories;

import com.smoothstack.common.models.Order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    
}
