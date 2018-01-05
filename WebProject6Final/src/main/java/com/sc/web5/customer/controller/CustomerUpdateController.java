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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sc.web5.customer.dao.CustomerDAO;
import com.sc.web5.customer.vo.Customer;

@Controller
@RequestMapping(value="customer")
@SessionAttributes("customer")
public class CustomerUpdateController {

	@Autowired
	CustomerDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerUpdateController.class);
	
	@RequestMapping(value="updateForm", method=RequestMethod.GET)
	public String updateForm(Model model,
			@SessionAttribute("id") String custid){
		logger.info("업데이트 폼 들어가기 시작");
		
		Customer customer = dao.searchCustomerOne(custid);
		model.addAttribute("customer", customer);
		
		logger.info("업데이트 폼 들어가기 종료");
		return "customer/updateForm";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Customer customer,
			@ModelAttribute("customer") Customer c){
		logger.info("업데이트 시작");
		int result = dao.updateCustomer(customer);
		
		if(result != 1){
			logger.info("회원 정보 수정 실패");
			return "customer/updateForm";
		}
		logger.info("업데이트 종료");
		
		return "customer/updateComplete";
	}
	
	@RequestMapping(value="updateComplete", method=RequestMethod.GET)
	public String updateComplete(String custid,SessionStatus sessionStatus,HttpSession session){
		logger.info("업데이트 완료 폼에서 홈으로 시작");
		Customer customer = dao.searchCustomerOne(custid);
		
		sessionStatus.setComplete();
		session.setAttribute("id", customer.getCustid());
		session.setAttribute("name", customer.getName());
		
		logger.info("업데이트 완료 폼에서 홈으로 종료");
		return "redirect:/";
	}
	
	
	
	
}
