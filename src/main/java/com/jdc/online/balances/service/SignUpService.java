package com.jdc.online.balances.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.h2.value.ValueArray;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.controller.anonymous.dto.SignUpForm;
import com.jdc.online.balances.model.entity.AccessHistory;
import com.jdc.online.balances.model.entity.Account;
import com.jdc.online.balances.model.entity.Member;
import com.jdc.online.balances.model.entity.MemberActivity;
import com.jdc.online.balances.model.entity.consts.MemberStatus;
import com.jdc.online.balances.model.entity.consts.Role;
import com.jdc.online.balances.model.repo.AccessHistoryRepo;
import com.jdc.online.balances.model.repo.AccountRepo;
import com.jdc.online.balances.model.repo.MemberActivityRepo;
import com.jdc.online.balances.model.repo.MemberRepo;
import com.jdc.online.balances.utils.exception.AppBusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpService {
	
	private final AccountRepo accountRepo;
	private final MemberRepo memberRepo;
	private final PasswordEncoder passwordEncoder;
	private final MemberActivityRepo memberActivityRepo;
	private final AccessHistoryService accessHistoryService;

	@Transactional
	public String signup(SignUpForm form) {
	
		if(accountRepo.existsById(form.getUsername())) {
			throw new AppBusinessException("Your email is already registered. Please try another email");
		}
		
		var account = new Account();
		account.setUsername(form.getUsername());
		account.setPassword(passwordEncoder.encode(form.getPassword()));
		account.setActive(true);
		account.setRole(Role.Member);
		
		account = accountRepo.save(account);
		
		var member = new Member();
		member.setAccount(account);
		member.setEmail(form.getUsername());
		member.setName(form.getName());
		
		memberRepo.save(member);
		
		var activity = new MemberActivity();
		activity.setMember(member);
		activity.setBalance(BigDecimal.ZERO);
		activity.setRegisteredAt(LocalDateTime.now());
		activity.setStatus(MemberStatus.Active);
		
		memberActivityRepo.save(activity);
		
		accessHistoryService.signup(form.getUsername());
		
		
		return "Your account has been created successfully. Please sign in again.";
	}

}
