package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.main.dao.StudentRepository;
import com.main.dto.StudentDTO;
import com.main.entity.StudentEntity;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository StudentRepository ;//Dao



//showall
	public List<StudentDTO> FetchAllStudents(){

		List<StudentEntity> entityList=StudentRepository.findAll();
		List<StudentDTO> dtoList=new ArrayList<>();//blank list
		for(  StudentEntity entity: entityList){

			StudentDTO dto=new StudentDTO();//blank object
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);


		}	

		return dtoList;
	}



//register
	@Override
	public void saveStu(StudentDTO stuDTO) {
		StudentEntity StudentEntity=new StudentEntity();
		BeanUtils.copyProperties(stuDTO, StudentEntity);
		StudentRepository.save(StudentEntity);

	}


//del
	@Override
	public void delStu(int ssn) {
		//StudentRepository.deleteById(ssn);
		StudentRepository.delStu(ssn);
	}




//edit
	@Override
	public StudentDTO findById(int ssn) {
		StudentEntity studentEntity= StudentRepository.findById(ssn).get();
		StudentDTO studentDTO= new StudentDTO();
		BeanUtils.copyProperties(studentEntity, studentDTO);

		return studentDTO;
	}




	@Override
	public void editStudent(StudentDTO studentDTO) {
		StudentEntity studentEntity=new StudentEntity();
		BeanUtils.copyProperties(studentDTO, studentEntity);
		StudentRepository.save(studentEntity);
	

		
	}



	@Override
	public StudentDTO authenticate(String email, String password) {
		Optional<StudentEntity> optional= StudentRepository.findByEmailAndPassword(email, password);
		StudentDTO studentDTO= null;
		if (optional.isPresent()){
			StudentEntity studentEntity= optional.get();
			studentDTO= new StudentDTO();

		BeanUtils.copyProperties(studentEntity, studentDTO);
		}
		return studentDTO;
	
	}
	

		
	}


	


