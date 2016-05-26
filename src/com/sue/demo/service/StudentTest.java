package com.sue.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sue.demo.mappers.StudentMapper;
import com.sue.demo.model.Student;
import com.sue.demo.util.SqlSessionFactoryUtil;

public class StudentTest {

	private SqlSession sqlSession = null;
	private StudentMapper sm = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		sm = sqlSession.getMapper(StudentMapper.class);
	}

	@Test
	public void testAdd() {
		Student s = new Student("李四3", 14);
		sm.add(s);
		sqlSession.commit();
	}

	@Test
	public void testUpdate() {
		Student s = new Student(7, "李四33", 3);
		sm.update(s);
		sqlSession.commit();
	}

	@Test
	public void testDelete() {
		sm.delete(7);
		sqlSession.commit();
	}

	@Test
	public void testFindById() {
		Student s = sm.findById(1);
		System.out.println(s);
	}

	@Test
	public void testFindAll() {
		List<Student> stuList = sm.findAll();
		for (Student s : stuList) {
			System.out.println(s);
		}
	}
	
	@Test
	public void findStudentWithAddress(){
		Student student = sm.findStudentWithAddress(1);
		System.out.println(student);
	}
	
	@Test
	public void testFindByIdWithGrade(){
	    Student student = sm.findStudentWithAddress(3);
	    System.out.println(student);
	}
	
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

}
