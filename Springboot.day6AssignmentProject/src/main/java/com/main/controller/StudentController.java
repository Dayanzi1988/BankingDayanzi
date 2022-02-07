package com.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.dto.StudentDTO;
import com.main.service.StudentService;

@Controller
public class StudentController {

	@Autowired

	StudentService studentService;
	 
	@GetMapping("login")
	String displayLoginPage(){

		return "login";//login.jsp

	}


	@PostMapping("login")
	String authenticate(@RequestParam String email ,@RequestParam String password ,HttpSession session){  //HttpServletRequest request

		System.out.println("from controller");

		StudentDTO studentDTO=studentService.authenticate(email, password);

		if (studentDTO!=null){
			session.setAttribute("studentDTO", studentDTO);

			return "congrates";
		}

		return "login";

	}

	
	@GetMapping ("logout")
	
	String logout (Model model, HttpSession session) {
		if (session!=null)
			session.invalidate();
			model.addAttribute("msg", "User has logged out");
			
			return "login";
		}

	@GetMapping("showStudent")

	String showAll(Model model, HttpSession session){	
		
		StudentDTO studentDTO = (StudentDTO) session.getAttribute("studentDTO");
		
		if (studentDTO!=null) {
		
		List<StudentDTO>   studentDTOlist=studentService.FetchAllStudents();	   

		model.addAttribute( "studentDTOlist", studentDTOlist);

		return "showAllStu";
		}
		else {
			return"login";
		}

	}
	
	@GetMapping("/register")
	String displayRegistrationPage() {

		return "registration";// registration.jsp

	}

	@PostMapping("register")
	String doRegistration(@ModelAttribute StudentDTO stuDTO, Model model) {

		studentService.saveStu(stuDTO);

		return "congrates";

	}

	@GetMapping("deleteStudent")
	String delStu(@RequestParam int ssn, Model model) {

		studentService.delStu(ssn);

		return "afterDelete";

	}

	@GetMapping("editStudent")
	String showEditStu(@RequestParam int ssn, Model model) {
		StudentDTO studentDTO = studentService.findById(ssn);
		model.addAttribute("studentDTO", studentDTO);
		return "editPage"; // open editPage.jsp }

	}

	@PostMapping("editStudent")
	String doEditAndDisplay(@ModelAttribute StudentDTO studentDTO, Model model) {
		studentService.editStudent(studentDTO);

		return "redirect:showStudent";

	}

}
