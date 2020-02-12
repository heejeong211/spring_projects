package edu.bit.emp.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import edu.bit.emp.vo.EmpVO;

//.xml을 만들거나 아니면 service 만들면 됨
public interface EmpMapper {

	@Select("select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp")
	public ArrayList<EmpVO> selectEmpList();

}
