package com.web.min.account.service;

import java.util.List;

import com.web.min.account.dto.AccountDTO;

public interface AccountService {
	public AccountDTO accountInfoDetail(AccountDTO dto) throws Exception;
	public List<AccountDTO> accountInfoList() throws Exception;	
}
