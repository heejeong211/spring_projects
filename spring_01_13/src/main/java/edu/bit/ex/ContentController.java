package edu.bit.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class ContentController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/board/content") 
	public String content(Model model) { 
		logger.info("/board/content ����");
		model.addAttribute("id", 30); //������ reqeust.setAttribute()�� �Ѱ��.
		return "board/content"; //���� �̸����� ������� ��.
	}
	
}
