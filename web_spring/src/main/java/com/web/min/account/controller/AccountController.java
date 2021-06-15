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
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model m, @ModelAttribute AccountDTO dto) throws Exception {
		String forward = "";
		
		// 서비스의 join method 호출
		boolean result = account.join(dto);
		
		if(result) {
			// 가입 성공했을 때 로그인 페이지로 리다이렉트
			forward = "redirect:/account/login";
		} else {
			// 가입 실패했을 때 회원가입 페이지 재전송
			m.addAttribute("data", dto);
			m.addAttribute(forward);
			forward = "account/join";
		}
		
		return forward;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login() throws Exception {
		
	}
	
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
