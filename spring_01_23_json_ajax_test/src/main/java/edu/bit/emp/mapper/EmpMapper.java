package edu.bit.emp.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import edu.bit.emp.vo.EmpVO;

//.xml�� ����ų� �ƴϸ� service ����� ��
public interface EmpMapper {

	@Select("select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp")
	public ArrayList<EmpVO> selectEmpList();

}
