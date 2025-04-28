package com.jdc.online.balances.controller.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.online.balances.service.AccessHistoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("admin/home")
public class AdminHomeController {
	
	
	@GetMapping
	String index() {
		return "management/home";
	}

}
