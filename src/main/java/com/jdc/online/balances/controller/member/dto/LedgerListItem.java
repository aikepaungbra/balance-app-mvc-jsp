package com.jdc.online.balances.controller.member.dto;

import java.time.LocalDateTime;

import com.jdc.online.balances.model.entity.consts.BalanceType;

public record LedgerListItem(
		int id,
		BalanceType type,
		boolean staus,
		LocalDateTime createAt,
		LocalDateTime modifiedAt,
		int total
		) {

	
}
