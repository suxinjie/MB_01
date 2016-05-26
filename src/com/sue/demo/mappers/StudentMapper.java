package com.sue.demo.mappers;

import java.util.List;

import com.sue.demo.model.Student;

public interface StudentMapper {

	public int add(Student student);

	public int update(Student student);

	public int delete(Integer id);

	public Student findById(Integer id);

	public List<Student> findAll();
	
	public Student findStudentWithAddress(int id);
	
	public Student findByGradeId(int id);
	
}
