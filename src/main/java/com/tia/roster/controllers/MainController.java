package com.tia.roster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tia.roster.models.Contact;
import com.tia.roster.models.Dorm;
import com.tia.roster.models.Student;
import com.tia.roster.services.RosterService;

@Controller
public class MainController {
	@Autowired
	private RosterService rosterService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("student")Student student) {
		rosterService.allStudents();
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String submitStudent(@Valid @ModelAttribute("student")Student student, BindingResult result) {
		rosterService.createStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/contact")
	public String contact(@Valid @ModelAttribute("contact")Contact contact, BindingResult result, Model model) {
		rosterService.allContacts();
		model.addAttribute(rosterService.allStudents());
		List<Student> students = rosterService.allStudents();
		model.addAttribute("students", students);
		
		Student student = new Student();
		Contact contact1 = new Contact();
		
		contact1.setStudent(student);
		student.setContact(contact1);
		rosterService.save(student);
		
		
		
		return "contact.jsp";
	}
	
	@PostMapping("/contact")
	public String submitContact(@Valid @ModelAttribute("contact")Contact contact, BindingResult result) {
		rosterService.createContact(contact);
		
	
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("student")Student student,Model model) {
		model.addAttribute("allStudents", rosterService.allStudents());
		model.addAttribute("allContacts", rosterService.allContacts());
		return "dashboard.jsp";
	}
	
	@GetMapping("/dorm")
	public String dorm(@ModelAttribute("dorm")Dorm dorm) {
		rosterService.allDorms();
		return "dorm.jsp";
	}
	
	@PostMapping("/dorm")
	public String createDorm(@Valid @ModelAttribute("dorm")Dorm dorm, BindingResult result) {
		rosterService.createDorm(dorm);
		return "redirect:/dorm";
	}
	
	@RequestMapping("/dorm/{id}")
	public String viewDorm(@PathVariable("id")Long id, @ModelAttribute("dorm")Dorm dorm, Model model) {
		model.addAttribute("dorm", rosterService.findDorm(id));
		model.addAttribute(rosterService.allStudents());
		List<Student> students = rosterService.allStudents();
		model.addAttribute("students", students);
		
		
		return "viewdorm.jsp";
	}
	
	@PostMapping("/dorm/{id}")
	public String addStudentToDorm(@PathVariable("id")Long dormId,@RequestParam("studentId")Long id, Model model) {
		model.addAttribute("student", rosterService.findStudent(id));
		
		Dorm dorm = rosterService.findDorm(dormId);
		Student student = rosterService.findStudent(id);
		
		student.setDorm(dorm);
		rosterService.save(student);
		
		model.addAttribute(rosterService.allStudents());
		
		
		
		return "redirect:/dorm/{id}";
		
		
	}
	@RequestMapping("/class")
	public String addClass() {
		
		return "class.jsp";
	}

	}



