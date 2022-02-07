package com.main.service;

import java.util.List;
import com.main.dto.StudentDTO;

public interface StudentService {		
	
	List<StudentDTO> FetchAllStudents();

	void saveStu(StudentDTO stuDTO);

	void delStu(int ssn);
	
	
	StudentDTO findById(int ssn);
	void editStudent(StudentDTO studentDTO);

	StudentDTO authenticate(String email, String password);
	

	
	

	
	
}
