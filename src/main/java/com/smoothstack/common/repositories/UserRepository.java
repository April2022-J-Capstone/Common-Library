package com.smoothstack.common.repositories;

import com.smoothstack.common.models.Review;
import com.smoothstack.common.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findTopByUserName(String userName);

    Review findByReviews_User_id(Integer userId);
}