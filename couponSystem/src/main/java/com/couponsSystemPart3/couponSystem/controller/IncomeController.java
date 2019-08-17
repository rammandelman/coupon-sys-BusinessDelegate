package com.couponsSystemPart3.couponSystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.couponsSystemPart3.couponSystem.model.Companies;
import com.couponsSystemPart3.couponSystem.model.Coupons;
import com.couponsSystemPart3.couponSystem.model.Customers;
import com.couponsSystemPart3.couponSystem.model.Income;
import com.couponsSystemPart3.couponSystem.model.Incomes;
import com.couponsSystemPart3.couponSystem.repository.IncomeRepository;

@RestController
@RequestMapping("/api")
public class IncomeController {
	
	
	@Autowired
	IncomeRepository incomeRepository;
	
	@PostMapping("/income")
	public Income AddIncome(@Valid @RequestBody Income income) {
		System.out.println("from coupon system the IncomeController, the income description  recived is: "+ income.getDescription());
		return incomeRepository.save(income);
	}
	
	@GetMapping("/allincomes")
	public List<Income> viewAllIncomes(){
		System.out.println("this all incomes func from coupoin system");
		return incomeRepository.findAll();
	}
	
//	@GET
//	@Path("/allincomes")
//	@Produces(MediaType.APPLICATION_XML)
//	public Incomes viewAllIncomes(){
//		List<Income> list = incomeRepository.findAll();
//		Incomes i = new Incomes();
//		i.incomesList = list;
//		 
//		 return i;
//	}
	
	@GetMapping("/allincomes_customer/{CUST_NAME}")
	public  List<Income> viewIncomeByCustomer(@PathVariable(value="CUST_NAME") String CUST_NAME) {
		List<Income> allincomes = incomeRepository.findAll();
		
		
		List<Income> customerIncomes = new ArrayList<Income>();
		
		for(Income i:allincomes) {
			if(i.getName().equals(CUST_NAME)) {
				customerIncomes.add(i);
			}
		}
		return customerIncomes;
				
	}
	@GetMapping("/allincomes_companie")
	public  List<Income> viewIncomeByCompany(@RequestParam(value="COMP_NAME") String COMP_NAME) {
		List<Income> allincomes = incomeRepository.findAll();
		List<Income> companieIncomes = new ArrayList<Income>();
		
		for(Income i:allincomes) {
			if(i.getName().equals(COMP_NAME)) {
				companieIncomes.add(i);
			}
		}
		return companieIncomes;
				
	}
}
