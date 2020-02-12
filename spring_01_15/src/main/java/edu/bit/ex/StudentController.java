package edu.bit.ex;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/studentForm")
	public String studentForm() {
		
		return "createPage";
	}
	
	/*
	 * @RequestMapping("/student/create") public String studentCreate(Student
	 * student, BindingResult result) { String page = "createDonePage";
	 * 
	 * StudentValidator validator = new StudentValidator();
	 * validator.validate(student, result); //������ ����(Errors -> BindingResult)
	 * if(result.hasErrors()) { //�ٽ��ڵ�, ���� �갡 Ʈ�縦 �����ϳ�? rejectValue �ȿ� �ϳ��� ������ true
	 * ����. page = "createPage"; }
	 * 
	 * return page; }
	 */
	
	@RequestMapping("/student/create")
	public String studentCreate(@Valid Student student, BindingResult result) {
		String page = "createDonePage";
		
		/*
		 * StudentValidator validator = new StudentValidator();
		 * validator.validate(student, result); //������ ����(Errors -> BindingResult)
		 */		
		
		if(result.hasErrors()) { //�ٽ��ڵ�, ���� �갡 Ʈ�縦 �����ϳ�? rejectValue �ȿ� �ϳ��� ������ true ����.
			page = "createPage";
		}
		
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator()); //StudentValidator(), �ڱⰡ �˾Ƽ� ���� �ּ�ó���� �κ� ����, �ڱⰡ �˾Ƽ� validator �Լ� ȣ���ϴ� ����.
	}
	
	
	
}
