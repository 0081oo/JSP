package com.web.hyun.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.hyun.dto.account.AccountDTO;

// @RequestMapping(value = "/account")
public class AccountController {

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String getJoin() {
		return "account/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String postJoin(@ModelAttribute AccountDTO dto) {
		System.out.println(dto.toString());
		return "redirect:/";
	}
}
