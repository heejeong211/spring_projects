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
	// http://localhost:8282/ex(���ؽ�Ʈ �н�)/�� �ڰ� ��Ʈ -> �̷��� ġ�� ������ String home �Լ��� �����.
	@RequestMapping(value = "/", method = RequestMethod.GET) //@RequestMapping-��Ʈ�ѷ��� ����� ���
	public String home(Locale locale, Model model) { // DispacherServlet�� �������� ��.
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // ��ü�� �����Ǽ� ����. DispacherServlet�� ����������. key-value ����. ���� ��Ȱ-������ �Ǵ� ��ü ����
		
		return "home";
	}
	
	@RequestMapping(value = "/board/view") 
	public String view() { 
		logger.info("/board/view ����");
		
		return "board/view"; //���� �̸����� ������� ��.
	}
	
}
