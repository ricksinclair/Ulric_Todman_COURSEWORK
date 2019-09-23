package com.trilogyed.rewardsservice.repository;

import com.trilogyed.rewardsservice.models.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Integer> {
    Optional<Rewards> findRewardsByRoomType(String roomType);
}
