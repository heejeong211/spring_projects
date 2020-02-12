package edu.bit.emp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.emp.mapper.EmpMapper;
import edu.bit.emp.vo.EmpVO;

@Service
public class EmpService {
	
	@Autowired
	EmpMapper empMapper;
	
	public ArrayList<EmpVO> selectEmpList() {
		return empMapper.selectEmpList();
	}
}
