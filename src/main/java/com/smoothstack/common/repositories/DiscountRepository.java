package com.smoothstack.common.repositories;

import com.smoothstack.common.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {

    Discount findByName(String discountName);

}