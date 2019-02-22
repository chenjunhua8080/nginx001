package com.nginx001.demo.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nginx001.demo.test.entity.A;

@Repository
public interface ADao extends JpaRepository<A, Integer>{
	
	A getById(Integer arg0);

}
