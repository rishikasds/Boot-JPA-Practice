package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.daos.StudentRepo;

@RestController
public class StudentController {
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("controller working");
		return "home.jsp";
      }
	
//	@RequestMapping("/addStudent")
//	public String addStudent(Student student ) {
//		repo.save(student);
//		return "home.jsp"; 
//		
//	}
//	
//	@RequestMapping("/getStudent")
//	public ModelAndView getStudent(@RequestParam int sid ) {
//		ModelAndView mv=new ModelAndView("showStudent.jsp");
//		Student stu = repo.findById(sid).orElse(new Student());
//		System.out.println(repo.findByTech("java"));
//		System.out.println(repo.findByTechSorted("java"));
//		mv.addObject(stu);
//		return mv; 
//		
//	}
	
//	@RequestMapping("/students")
//	@ResponseBody
//	public String getAllStudents() {
//		return repo.findAll().toString();
//	}
//	@RequestMapping("/student/{sid}")
//	@ResponseBody
//	public String getSpecificStudent(@PathVariable("sid") int sid) {
//		return repo.findById(sid).toString();
//	}
	
	@RequestMapping("/students")
	@ResponseBody
	public  List<Student> getStudents() {
		return repo.findAll();
	}
	
	@RequestMapping("/student/{sid}")
	@ResponseBody
	public Optional<Student> getStudent(@PathVariable("sid") int sid) {
		return repo.findById(sid);
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student stu) {
		repo.save(stu);
		return stu;
	}
	
	@DeleteMapping("/student/{sid}")
	public String deleteStudent(@PathVariable int sid) {
		repo.deleteById(sid);
		return "deleted";
	}
	
	@PutMapping("/student")
	public Student saveOrUpdateStudent(@RequestBody Student stu) {
		repo.save(stu);
		return stu;
	}
}
