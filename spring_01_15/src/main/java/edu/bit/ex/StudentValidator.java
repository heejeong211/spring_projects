package edu.bit.ex;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Student.class.isAssignableFrom(arg0); //검증할 객체의 클래스 타입 정보(공식)
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Student student = (Student) obj; //Student를 검사하기 위해 자식으로 형변환 시켜줘야 함.(obj 최고조상)
		
		String studentName = student.getName();
		
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble"); //이게 키워드, 에러가 생기면 발생
		}
		//위에 4줄 줄여서 
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble"); //rejectIfEmptyOrWhitespace, static 함수(객체생성안하고 바로 호출해서)
		
		
		int studentId = student.getId();
		
		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}
		
	}

}
