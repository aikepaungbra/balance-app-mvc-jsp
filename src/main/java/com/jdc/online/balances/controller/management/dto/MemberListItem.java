package com.jdc.online.balances.controller.management.dto;

import java.time.LocalDateTime;

public record MemberListItem(
		long id,
		String name,
		LocalDateTime registeredAt,
		LocalDateTime lastLogoinAt,
		boolean status,
		LocalDateTime changeAt,
		String remark
		) {

}
