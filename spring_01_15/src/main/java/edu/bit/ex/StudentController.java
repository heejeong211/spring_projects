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
	 * validator.validate(student, result); //다형성 적용(Errors -> BindingResult)
	 * if(result.hasErrors()) { //핵심코드, 언제 얘가 트루를 리턴하냐? rejectValue 안에 하나라도 있으면 true
	 * 나옴. page = "createPage"; }
	 * 
	 * return page; }
	 */
	
	@RequestMapping("/student/create")
	public String studentCreate(@Valid Student student, BindingResult result) {
		String page = "createDonePage";
		
		/*
		 * StudentValidator validator = new StudentValidator();
		 * validator.validate(student, result); //다형성 적용(Errors -> BindingResult)
		 */		
		
		if(result.hasErrors()) { //핵심코드, 언제 얘가 트루를 리턴하냐? rejectValue 안에 하나라도 있으면 true 나옴.
			page = "createPage";
		}
		
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator()); //StudentValidator(), 자기가 알아서 저기 주석처리한 부분 실행, 자기가 알아서 validator 함수 호출하는 것임.
	}
	
	
	
}
