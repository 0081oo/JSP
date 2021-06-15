package com.web.min.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ajax/account")
public class AjaxAccountController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody // ViewResolver 를 사용하지 않음
	public String checkNickname(@RequestParam String nickname) throws Exception {
		return "account/join";
	}
}
