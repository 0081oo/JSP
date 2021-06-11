package com.web.min.account.repository;

import java.util.List;

import com.web.min.account.dto.AccountDTO;

/*
 * 데이터베이스 조작과 관련된 기능을 나열한 인터페이스
 */
public interface AccountRepository {
	public AccountDTO select(AccountDTO dto) throws Exception;
	public List<AccountDTO> selectList() throws Exception;
}
