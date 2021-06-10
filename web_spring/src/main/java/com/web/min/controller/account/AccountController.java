package com.web.min.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.min.controller.sp3.ParameterVO;
import com.web.min.dto.account.AccountDTO;

@Controller
@RequestMapping(value="/account")
public class AccountController {
	
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String getJoin() {
		return "account/join";
	}
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String postJoin(@ModelAttribute AccountDTO dto) {
		System.out.println(dto.toString());
		return "redirect:/"; // 리다이렉트 하는 법(일반 메인페이지)
	}
}
