package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Blogger;

@Repository
public interface BloggerRepository extends JpaRepository<Blogger, Integer> {

	
}
