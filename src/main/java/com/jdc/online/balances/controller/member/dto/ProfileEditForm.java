package com.jdc.online.balances.controller.member.dto;

import java.time.LocalDate;

import com.jdc.online.balances.model.entity.consts.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfileEditForm {

	@NotBlank(message = "Please enter name.")
	private String name;
	@NotNull(message = "Please select gender.")
	private Gender gender;
	@NotNull(message = "Please select date of birth.")
	private LocalDate dob;
	@NotBlank(message = "Please enter phone.")
	private String phone;
	@NotBlank(message = "Please enter email.")
	private String email;
	private int region;
	private int district;
	@NotNull(message = "Please select township.")
	private int township;
	@NotBlank(message = "Please enter address.")
	private String address;
	
	private String profileImage;
	
}
