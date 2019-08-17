package com.couponsSystemPart3.couponSystem.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.couponsSystemPart3.couponSystem.model.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long>{
	
	
}
