package com.example.moattravel.repository;

import java.awt.print.Pageable;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel.entity.House;

public interface HouseRepository extends JpaRepository<House, Integer> {
    // JpaRepositoryのメソッドがすべて使える（findAllも含む）
	
	public Page<House>findByNameLike(String keyword,Pageable pageable);
}
