package com.web.min.controller.sp3;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/param")
public class ParamController {
	@RequestMapping(value="")
	public String main() {
		return "sp3/main";
	}
	
	@RequestMapping(value="/get1")
	public ModelAndView get1(HttpServletRequest req, HttpServletResponse rsp) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sp3/get1");
		mv.addObject("value",req.getParameter("name"));
		return mv;
	}
	
	@RequestMapping(value="/post1", method = RequestMethod.POST)
	public ModelAndView post1(HttpServletRequest req, HttpServletResponse rsp) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sp3/post1");
		mv.addObject("value",req.getParameter("name"));
		return mv;
	}
}
