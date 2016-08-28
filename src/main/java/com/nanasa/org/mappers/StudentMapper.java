package com.nanasa.org.mappers;

import com.nanasa.org.models.Student;

import java.util.List;

/**
 * Created by Ujitha on 8/20/2016.
 */
public interface StudentMapper {

    public void insertStudent(Student student);

    public Student getStudentById(int studentId);

    public List<Student> getAllStudents();

    public void updateStudent(Student student);

    public void deleteStudent(int studentId);
}
