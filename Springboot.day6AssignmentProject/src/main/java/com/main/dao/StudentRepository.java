package com.main.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

	
	//Optional<StudentEntity> findByEmailIdAndPassword(String email, String password);

	//Delete operation
	//void delStu(int ssn);
	//you can use following if you do not want to use inbuilt method deleteById(..)
	@Modifying
	@Query("delete from StudentEntity e where e.ssn=:ssn")
	void delStu(@Param("ssn") int ssn);


	//Update operation
	Optional<StudentEntity> findById(int ssn);
	
	@Modifying
	@Query("update StudentEntity ee set ee.ssn= :ssn") 
	void editStudent(@Param("ssn") int ssn);


	Optional<StudentEntity> findByEmailAndPassword(String email, String password);

	

}
