package com.sc.web5.customer.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.web5.customer.dao.CustomerDAO;
import com.sc.web5.customer.vo.Customer;

@Controller
@RequestMapping(value = "customer")
public class CustomerLoginController {
	// 로그인에서는 @ModelAttribute를 안 쓰는 이유는 로그아웃을 하면서 세션에 남겨야 되는 데이터가 있을 수 있어서 그냥
	// model을 직접 넣음

	@Autowired
	CustomerDAO dao;

	private static final Logger logger = LoggerFactory.getLogger(CustomerLoginController.class);

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpSession session, String id) {
		logger.info("회원가입 후 로그인 시작");

		Customer customer = dao.searchCustomerOne(id);
		session.setAttribute("id", customer.getCustid());
		session.setAttribute("name", customer.getName());

		logger.info("회원가입 후 로그인 종료");
		return "redirect:/";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session, String custid, String password, Model model) {
		logger.info("로그인 시작");
		Customer customer = dao.searchCustomerOne(custid);

		if (customer == null) {
			String msg = "아이디와 비밀번호를 확인하세요.";
			model.addAttribute("msg", msg);
			logger.info("아이디 일치 안 함");
			return "customer/loginForm";
		}

		if (!customer.getPassword().equals(password)) {
			String msg = "아이디와 비밀번호를 확인하세요.";
			model.addAttribute("msg", msg);
			logger.info("비밀번호 일치 안함");
			return "customer/loginForm";
		}

		session.setAttribute("id", custid);
		session.setAttribute("name", customer.getName());

		logger.info("로그인 종료");
		return "redirect:/";
	}

	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("로그인 폼 들어가기 시작");

		logger.info("로그인 폼 들어가기 종료");
		return "customer/loginForm";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("로그아웃 시작");

		session.setAttribute("id", null);
		session.setAttribute("name", null);
		// session.setAttribute("customer", null);

		logger.info("로그아웃 종료");
		return "redirect:/";
	}

}
