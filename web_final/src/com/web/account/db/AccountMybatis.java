package com.web.account.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AccountMybatis {
	SqlSession sess = null;
	
	public AccountMybatis() {
		this.connect();
	}
	
	private void connect() {
		try {
			String resource = "resources/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			sess = factory.openSession();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 *  @param String nickname
	 *  @return boolean
	 *  이미 등록된 닉네임이 있는지 확인하는 메소드
	 *  등록된 닉네임이 있는 경우 true, 등록된 닉네임이 없는 경우 false 반환
	 */
	public boolean usedNickname(String nickname) {
		boolean res = true;
		int cnt = this.sess.selectOne("accountMapper.checkNickname", nickname);
		System.out.println(cnt);
		if(cnt == 0) {
			res = false;
		}
		return res;
	}
}
