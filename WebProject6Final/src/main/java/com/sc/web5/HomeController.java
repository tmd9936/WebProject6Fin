package com.sc.web5;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//로그파일을 만들수 있게 해주는 클래스
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//나중에 로그파일을 읽었을 때 정보를 적어주는 것
		logger.info("프로젝트 인덱스 페이지 시작");
		
		logger.info("프로젝트 인덱스 페이지 종료");
		
		//debug는 개발단계에서 사용하는 것
		//logger.debug("");
		
		return "home";
	}
	
}
