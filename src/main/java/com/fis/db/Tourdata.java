package com.fis.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.entity.Tour;

public interface Tourdata extends JpaRepository<Tour, String>{
	

}
