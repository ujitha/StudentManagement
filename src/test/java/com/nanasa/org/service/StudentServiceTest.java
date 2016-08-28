package com.nanasa.org.service;

import com.nanasa.org.models.Student;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ujitha on 8/20/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class StudentServiceTest {

//    private static StudentService studentService;
    @Autowired
    private StudentService studentService;

    @BeforeClass
    public static void setup() {
//        studentService = new StudentService();
    }

    @AfterClass
    public static void teardown() {
//        studentService = null;
    }

    @Test
    public void getStudentByIdTest() {
        Student student = studentService.getStudentById(1);
        assertEquals("Student name should be same", "Saman", student.getName());
    }

    @Test
    public void getStudentsTest() {
        List<Student> studentList = studentService.getAllStudents();
        assertEquals("First Studen name should be same", "Saman", studentList.get(0).getName());
        assertEquals("Second student name should be same", "Kamal", studentList.get(1).getName());
        for(Student student: studentList) {
            System.out.println(student.getId() + "- " + student.getName());
        }
    }

    @Test
    public void insertStudentTest() {
        Student student = new Student();
        student.setName("Upul");
        student.setAddress("Kandy");
        student.setJoinDate("2016-02-02");
        student.setMobileNumber("0711234567");
        studentService.insertStudent(student);
        assertTrue(student.getId() != 0);
        Student createdStudent = studentService.getStudentById(student.getId());
        assertEquals("Name should be same", student.getName(), createdStudent.getName());
    }

    @Test
    public void updateUser() {
        Student student = studentService.getStudentById(2);
        student.setName("Sunil");
        studentService.updateStudent(student);
        Student updatedStudent = studentService.getStudentById(2);
        assertEquals("Sunil", updatedStudent.getName());
    }

    @Test
    public void deleteStudenTest() {
        Student student = studentService.getStudentById(7);
        studentService.deleteStudent(student.getId());
        Student deletedStudent = studentService.getStudentById(student.getId());
        assertNull(deletedStudent);
    }
}
