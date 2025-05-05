package com.jdc.online.balances.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.controller.member.dto.LedgerListItem;
import com.jdc.online.balances.controller.member.dto.LedgerSearch;
import com.jdc.online.balances.model.PageResult;
import com.jdc.online.balances.model.repo.LedgerRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LedgerManagementService {
	
	private final LedgerRepo ledgerRepo;
	
	@Transactional(readOnly = true)
	public PageResult<LedgerListItem> search(String username, LedgerSearch form, int page, int size) {
		
		return null;
	}

}
