package com.jdc.online.balances.controller.management;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.online.balances.controller.member.dto.AccessHistorySearch;
import com.jdc.online.balances.service.AccessHistoryService;

import lombok.RequiredArgsConstructor;

@Controller("adminMemberAccessController")
@RequiredArgsConstructor
@RequestMapping("admin/access")
public class MemberAccessController {
	
	private final AccessHistoryService service;
	
	@GetMapping
	String search(
			ModelMap model,
			AccessHistorySearch form,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int size
			) {
		
		
		var result = service.search(form, page, size);
		model.put("result", result);
		
		return "management/access/list";
	}

}
