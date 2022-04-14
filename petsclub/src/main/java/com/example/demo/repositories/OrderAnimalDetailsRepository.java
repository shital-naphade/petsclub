package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.OrderAnimalDetails;

@Transactional
public interface OrderAnimalDetailsRepository extends JpaRepository<OrderAnimalDetails, Integer> {

}
