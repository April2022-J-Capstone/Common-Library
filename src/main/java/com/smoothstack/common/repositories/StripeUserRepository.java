package com.smoothstack.common.repositories;

import com.smoothstack.common.models.StripeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StripeUserRepository extends JpaRepository<StripeUser, Integer> {

}
