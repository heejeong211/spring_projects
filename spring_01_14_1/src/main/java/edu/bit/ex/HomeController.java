package edu.bit.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.ex.member.Member;
import edu.bit.ex.student.StudentInfomation;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("board/confirm") //get방식으로 다이렉트로 아이디와 비밀번호 때려 넣는 코드, HttpServletRequest로 받아오는 방법 jsp랑 방법이 동일함
	public String confirm(HttpServletRequest req, Model model) {
		logger.info("confirm");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirm";
	}
	
	@RequestMapping("board/check") //@RequestParam로 받아오는 방법
	public String check(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		logger.info("check");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/check";
	}
	
	@RequestMapping("member/join") //커맨드 객체 생성해서 받아오는 방법
	public String join(Member member) {
		logger.info("join");
		
		return "member/join";
	}
	
	@RequestMapping("/index") //form태그
	public String index() {
		logger.info("index");
		
		return "index";
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST) //인자가 두개 들어갈 것 같으면 value 붙여줘야 함.
	public String student(HttpServletRequest req, Model model) {
		logger.info("student"); // sysout 보다 이게 더 좋음
		
		System.out.println("RequestMethod.POST");
		String id = req.getParameter("id");
		System.out.println("id : " + id);
		model.addAttribute("id", id);
		
		return "student";
	}
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public ModelAndView student(HttpServletRequest req) { //함수 오버로딩
		logger.info("student"); // sysout 보다 이게 더 좋음
		
		System.out.println("RequestMethod.GET");
		String id = req.getParameter("id");
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("id : " + id);
		mv.addObject("id", id);
		mv.setViewName("student");
		
		return mv;
	}
	
	@RequestMapping("/studentIndex") //form태그
	public String studentIndex() {
		logger.info("studentIndex");
		
		return "studentIndex";
	}
	
	@RequestMapping("/studentView")
	public String studentView(@ModelAttribute("studentInfo") StudentInfomation studentInformation) {
		logger.info("studentView");
		
		return "studentView";
	}
	
}
