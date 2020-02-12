package edu.bit.ex;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class RedirectController {
	
	private static final Logger logger = LoggerFactory.getLogger(RedirectController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/studentConfirm")
	public String studentConfirm(HttpServletRequest req, Model model) {
		logger.info("student");
		
		String id = req.getParameter("id");
		
		if(id.equals("abc")) { //���̵� abc�� ������ studentOk�� ����
			return "forward:studentOk"; //redirect:studentOk
		}
		
		return "forward:studentNg"; //�ƴϸ� studentNg�� ���� //redirect:studentNg
	}
	
	@RequestMapping("/studentOk")
	public String studnetOk(Model model) {
		logger.info("studentOk");
	
		return "student/studentOk";
	}
	
	@RequestMapping("/studentNg")
	public String studnetNg(Model model) {
		logger.info("studentNg");
	
		return "student/studentNg";
	}
	
	
	
}
