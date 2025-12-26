package com.example.moattravel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel.entity.House;

public interface HouseRepository extends JpaRepository<House, Integer> {
    // JpaRepositoryのメソッドがすべて使える（findAllも含む）
	    Page<House> findByNameLikeOrAddressLike(
	        String nameKeyword, String addressKeyword, Pageable pageable);

	    Page<House> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(
	        String nameKeyword, String addressKeyword, Pageable pageable);

	    Page<House> findByNameLikeOrAddressLikeOrderByPriceAsc(
	        String nameKeyword, String addressKeyword, Pageable pageable);

	    Page<House> findByAddressLike(String area, Pageable pageable);
	    
	    Page<House> findByNameLike(String name, Pageable pageable);

	    Page<House> findByAddressLikeOrderByCreatedAtDesc(
	        String area, Pageable pageable);

	    Page<House> findByAddressLikeOrderByPriceAsc(
	        String area, Pageable pageable);

	    Page<House> findByPriceLessThanEqual(Integer price, Pageable pageable);

	    Page<House> findByPriceLessThanEqualOrderByCreatedAtDesc(
	        Integer price, Pageable pageable);

	    Page<House> findByPriceLessThanEqualOrderByPriceAsc(
	        Integer price, Pageable pageable);

	    Page<House> findAllByOrderByCreatedAtDesc(Pageable pageable);

	    Page<House> findAllByOrderByPriceAsc(Pageable pageable);
	    
	    public List<House>findTop10ByOrderByCreatedAtDesc();
	}

