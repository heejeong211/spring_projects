package edu.bit.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.EmpService;
import edu.bit.board.vo.EmpVO;

@RestController
@RequestMapping("/rest/*")
public class EmpRestController {
	
	@Autowired
	private EmpService empServie;
	
	@RequestMapping("/emp")
	public List<EmpVO> emp(Model model) {
		
		System.out.println("emp");
		
		List<EmpVO> empList = empServie.selectAllEmpList();
		
		System.out.println(empList.size());
		
		return empList;
		
		
	}
	
	//ë¡œê·¸?•„?›ƒ
	@RequestMapping(value="/logout")
	public String login(HttpSession session) {
		
		System.out.println("login ?˜¸ì¶?");
		
		session.invalidate();
		
		return "redirect:/";
	}

}
