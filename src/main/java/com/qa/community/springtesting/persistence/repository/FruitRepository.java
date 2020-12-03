package com.qa.community.springtesting.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.community.springtesting.persistence.domain.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

}
