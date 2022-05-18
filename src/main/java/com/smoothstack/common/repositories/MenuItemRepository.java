package com.smoothstack.common.repositories;

import java.util.List;

import com.smoothstack.common.models.MenuItem;
import com.smoothstack.common.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    List<MenuItem> findAllByRestaurants(Restaurant restaurants);
}