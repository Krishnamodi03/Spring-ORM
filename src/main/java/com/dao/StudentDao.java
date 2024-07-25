package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Student;

public class StudentDao {

	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// method to save employee
	@Transactional
	public int saveStudent(Student s) {
		int id = (int) template.save(s);
		return id;
	}
	@Transactional
	// method to update employee
	public void updateStudent(Student s) {
		template.update(s);
	}
	@Transactional
	// method to delete employee
	public void deleteStudent(Student s) {
		template.delete(s);
	}

	//method to return one employee of given id 
	public Student fetchById(int id) {
		Student s = (Student)template.get(Student.class,id);
		return s;
	}
	
	//method to return all employees
	public List<Student> fetchAllStudent(){
		List<Student> list = new ArrayList<Student>();
		list  = template.loadAll(Student.class);
		return list;
	}
	
}
