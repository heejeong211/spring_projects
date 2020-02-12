package edu.bit.emp.controller;

import java.util.List;

import javax.inject.Inject;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.emp.service.EmpService;
import edu.bit.emp.vo.EmpVO;

@RestController
@RequestMapping("/rest/*")
public class EmpRestController {
	 
	@Inject
	EmpService empService;
	
	@RequestMapping("/list")
	public List<EmpVO> list() {
		
		System.out.println("list()");
		
		List<EmpVO> empList = empService.selectEmpList();
		
		return empList;
	}
}
