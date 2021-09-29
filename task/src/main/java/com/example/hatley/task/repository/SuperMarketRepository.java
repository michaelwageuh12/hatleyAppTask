package com.example.hatley.task.repository;

import com.example.hatley.task.entity.SuperMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperMarketRepository extends JpaRepository<SuperMarket, Long> {

}
