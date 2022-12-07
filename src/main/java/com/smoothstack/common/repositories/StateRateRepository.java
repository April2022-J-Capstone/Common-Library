package com.smoothstack.common.repositories;

import com.smoothstack.common.models.StateRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRateRepository extends JpaRepository<StateRate, Integer> {
    StateRate findByName(String name);
}
