package com.jdc.online.balances.service;

import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.model.entity.AccessHistory;
import com.jdc.online.balances.model.entity.consts.AccessStatus;
import com.jdc.online.balances.model.entity.consts.AccessType;
import com.jdc.online.balances.model.entity.embeddables.AccessHistoryPk;
import com.jdc.online.balances.model.repo.AccessHistoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccessHistoryService {
	
	private final AccessHistoryRepo accessHistoryRepo;
	
	@Transactional
	public void signup(String username) {
		
		createHistory(username, AccessType.SignUp, AccessStatus.Success);
		
	}

	private void createHistory(String username, AccessType type, AccessStatus status) {
		
		var id = new AccessHistoryPk();
		id.setUsername(username);
		id.setAccessAt(Instant.now());
		
		var history = new AccessHistory();
		history.setId(id);
		history.setStatus(status);
		history.setType(type);
		
		accessHistoryRepo.save(history);
	}

}
