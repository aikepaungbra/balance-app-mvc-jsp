package com.jdc.online.balances.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.controller.member.dto.MemberProfileDetails;
import com.jdc.online.balances.model.repo.MemberRepo;
import com.jdc.online.balances.utils.EntityOperations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberProfileService {
	
	private final MemberRepo repo;
	

	@Transactional(readOnly = true)
	@PreAuthorize("hasAuthority('Admin') or #username eq authentication.name")
	public MemberProfileDetails loadProfile(String username) {
		
		return EntityOperations.safeCall(repo.findOneByAccountUsername(username)
				.map(MemberProfileDetails::from),
				"Member", "login id", username);
	}

}
