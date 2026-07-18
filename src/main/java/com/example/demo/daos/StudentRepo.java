package com.example.demo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Student;

//public interface StudentRepo extends CrudRepository<Student,Integer>{
// 
//	 List<Student> findByTech(String tech);
//	 @Query("from Student s where s.tech =?1 order by s.sname")
//	 List<Student> findByTechSorted(String tech);
//	 
//}
public interface StudentRepo extends JpaRepository<Student,Integer>{
}
