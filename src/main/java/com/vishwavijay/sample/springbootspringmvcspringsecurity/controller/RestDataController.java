package com.vishwavijay.sample.springbootspringmvcspringsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishwavijay.sample.springbootspringmvcspringsecurity.response.Status;

@RestController
@RequestMapping("/api/data")
public class RestDataController {
	
	@RequestMapping("/user") 
	public Status getUserStatus() {
		return Status.of("status of user.. can be accessed by user only.");
	}
	
	@RequestMapping("/admin") 
	public Status getAdminStatus() {
		return Status.of("status of admin.. can be accessed by admin only..");
	}
	
	@RequestMapping("/tester") 
	public Status getTesterStatus() {
		return Status.of("status of tester.. can be accessed by tester only...");
	}
	
	
}
