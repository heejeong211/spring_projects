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
		logger.info("erroró�� ����");
		//404���� �߻��� ó���� ������ ������ ó���� ��Ŵ
	
		return "error/error404";
	}
	
}
