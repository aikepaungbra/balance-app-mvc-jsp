package com.jdc.online.balances.utils.formatter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class AppDateTimeFormatterModelAttributes {
	
	@ModelAttribute("dtf")
	public AppDateTimeFormatter appDateTimeFormatter() {
		return new AppDateTimeFormatter();
	}

}
