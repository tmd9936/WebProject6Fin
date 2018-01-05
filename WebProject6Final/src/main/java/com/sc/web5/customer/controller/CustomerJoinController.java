package com.sc.web5.customer.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sc.web5.customer.dao.CustomerDAO;
import com.sc.web5.customer.vo.Customer;

@Controller
@RequestMapping(value = "customer")
@SessionAttributes("customer")
//이렇게 붙혀주면 자동으로 앞에 /customer가 붙은 상태로 옴
//그래서 만약 /customer/joinForm으로 링크를 타고 왔다면 아래처럼 value에 joinForm만 붙혀주면 됨
//그리고 내가 메인페이지로 돌아 갈 때 현재 페이지를 return "redirect:/";로 바꿔줘야 됨
public class CustomerJoinController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerJoinController.class);

	@Autowired
	CustomerDAO dao; //dao도 스프링한테 달라고 해야됨 dao에 @레포지토리를 해놔서 가능한 것
	
	@RequestMapping(value = "joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {
		logger.info("회원 가입 폼 이동 시작");
		
		//비정상적인 경로로 들어오는 것을 막기위해 하는 사전 작업
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		
		logger.info("회원 가입 폼 이동 종료");
		//(링크)리퀘스트 경로의 구조랑 webapp의 파일의 경로 구조랑 다른 부분이라서
		//만약 링크경로와 파일경로의 이름이 같다고 해도 파일 경로의 모든 경로를 붙혀줘야됨
		return "customer/joinForm";
	}
	
	//윈도우로 새창 띄우는 방식은 get, 그냥 form에서 post 부르는거 빼고는 다 get임
	@RequestMapping(value="idCheck",method=RequestMethod.GET)
	public String idCheck(Model model){
		logger.info("id중복확인 창 이동 시작");
		//검색 유무 확인 데이터
		//두 가지의 경우의 수가 있음 
		//첫 번째는 id중복확인을 누르고 처음으로 들어온 경우
		//두 번째는 검색을 누르고 다시 호출되는 경우 
		model.addAttribute("search", false);//새로 뜬 창이 검색으로 들어온 창이 아니다.라는 것을 알려주기 위한 변수 
		
		logger.info("id중복확인 창 이동 종료");
		
		return "customer/idCheckForm";
	}
	
	@RequestMapping(value="idSearch", method=RequestMethod.POST)
	public String idSearch(String searchId,Model model){
		logger.info("아이디 중복 시작");
		
		Customer customer = dao.searchCustomerOne(searchId);
		
		model.addAttribute("searchId", searchId);
		model.addAttribute("searchResult", customer);
		model.addAttribute("search", true);
		
		logger.info("아이디 중복 종료");
		return "customer/idCheckForm";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(
			//원래는 session이랑 model이랑 이름을 공유한 상태에서 부르면 오류가 뜨는네
			//여기서는 회원가입 폼에서 미리 빈 클래스를 넣어놨기 대문에 오류가 안 걸림
			//join이라는 곳으로 사용자가 원하던 루트가 아니라 다른 루트를 타고 왔을 때 막아주는 역활
			//join폼을 지나서 왔다면 model의 customer에 값을 덮어 쓰고 만약 실패해서 가입을 못해도 쓰던게 그대로 남아 있음
			//원래 기능은 받아온 데이터를 model에 addAttribute해주는 거랑 같음
			@ModelAttribute("customer") Customer customer, Model model){
		logger.info("회원 등록 시작");
		int result = dao.joinCustomer(customer);
		
		if(result != 1){
			//등록 실패
			logger.info("회원 등록 실패");
			model.addAttribute("errorMsg", "등록 실패");
			return "customer/joinForm";
		}
		
		//등록 성공
		logger.info("회원 등록 성공");
		return "redirect:joinComplete";
	}
	
	@RequestMapping(value="joinComplete", method=RequestMethod.GET)
	public String joinComplete(SessionStatus session,
			Model model,
			//join이라는 곳으로 사용자가 원하던 루트가 아니라 다른 루트를 타고 왔을 때 막아주는 역활을 위해 추가 id는 덤으로 추가 해줌
			@ModelAttribute("customer") Customer customer){
		logger.info("회원 가입 성공 폼 이동 시작");
		model.addAttribute("id",customer.getCustid());
		//세션의 모든관계를 없에주는 함수임
		//이게 사용자가 직접 세션에 값을 넣은게 아니고 모델이랑 
		//연결 되어있는 구조라서 (아마 model의 주소를 session이 참조하는 것?) setComplete로 관계를 없에줘야 없어짐
		session.setComplete();
		
		logger.info("회원 가입 성공 폼 이동 종료");
		return "customer/joinComplete";
	}
	
	
}














