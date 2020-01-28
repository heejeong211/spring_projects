package edu.bit.board;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/404")
	public String error404(Locale locale, Model model) {
		logger.info("error404");
		logger.info("error처리 매핑");
		//404에러 발생시 처리할 내용이 있으면 처리를 시킴
	
		return "error/error404";
	}
	
}
