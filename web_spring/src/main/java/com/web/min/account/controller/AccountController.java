package com.web.min.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.min.account.dto.AccountDTO;
import com.web.min.account.service.AccountService;

@Controller	// bean 객체로 등록
@RequestMapping(value = "/user")	// URL 주소 mapping
public class AccountController {
	
	@Autowired	// 자동으로 AccountService 객체 생성하고 필요한 것들 주입
	AccountService account;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String userList(Model m) throws Exception {
		List<AccountDTO> datas = account.accountInfoList();
		m.addAttribute("datas", datas);
		System.out.println(datas.get(0).toString());
		return "user/list";
	}
	
	// http://localhost:8080/min/user/detail?id=1
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String userDetail(Model m, @ModelAttribute AccountDTO dto) throws Exception {
		AccountDTO data = account.accountInfoDetail(dto);
		m.addAttribute("data", "service로 조회 요청을 한다.");
		System.out.println(data.toString());
		return "user/detail";
	}
}
