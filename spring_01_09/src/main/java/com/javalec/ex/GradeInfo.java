package com.javalec.ex;

public class GradeInfo {
	
	private int kor;
	private int eng;
	private int math;
	private Grade grade;
	
	public void gradeInfoTest() {
		System.out.println("국어");
		grade.grade(kor);
		System.out.println("영어");
		grade.grade(eng);
		System.out.println("수학");
		grade.grade(math);
	}
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
}
