package com.smoothstack.common.repositories;

import java.util.List;
import java.util.Optional;

import com.smoothstack.common.models.OrderItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    Optional<List<OrderItem>> findAllByOrder_id(Long order_id);
}