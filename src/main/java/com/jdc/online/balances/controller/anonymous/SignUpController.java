package com.jdc.online.balances.controller.anonymous;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.online.balances.controller.anonymous.dto.SignUpForm;
import com.jdc.online.balances.service.SignUpService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {
	
	private final SignUpService service;
	
	@GetMapping
	String index() {
		return "anonymous/signup";
	}
	
	@PostMapping
	String signUp(
			@Validated @ModelAttribute(name = "form") SignUpForm signUpForm,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			ModelMap model
			) {
		
		if(result.hasErrors()) {
			return "anonymous/signup";
		}
		
		try {
			
			var message = service.signup(signUpForm);
			
			redirectAttributes.addFlashAttribute("message", message);
			
			
			return "redirect:/signin";

			
		}catch(Exception e) {
			model.put("message", e.getMessage());
			return "anonymous/signup";
		}
				
		
	}
	
	@ModelAttribute(name = "form")
	SignUpForm signUpForm() {
		return new SignUpForm();
	}
}
