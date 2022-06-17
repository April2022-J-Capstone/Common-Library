package com.smoothstack.common.repositories;

import com.smoothstack.common.models.Location;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<List<Location>> findAllByLocationName(String name);
}