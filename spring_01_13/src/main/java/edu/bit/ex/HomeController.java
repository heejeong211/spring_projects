package edu.bit.ex;

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
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// http://localhost:8282/ex(컨텍스트 패스)/이 뒤가 루트 -> 이렇게 치고 들어오면 String home 함수가 실행됨.
	@RequestMapping(value = "/", method = RequestMethod.GET) //@RequestMapping-컨트롤러를 만드는 방법
	public String home(Locale locale, Model model) { // DispacherServlet이 생성시켜 줌.
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // 객체가 생성되서 들어옴. DispacherServlet가 생성시켜줌. key-value 형태. 모델의 역활-데이터 또는 객체 전달
		
		return "home";
	}
	
	@RequestMapping(value = "/board/view") 
	public String view() { 
		logger.info("/board/view 실행");
		
		return "board/view"; //폴더 이름까지 적어줘야 함.
	}
	
}
