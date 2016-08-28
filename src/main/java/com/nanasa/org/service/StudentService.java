package com.nanasa.org.service;

import com.nanasa.org.mappers.StudentMapper;
import com.nanasa.org.models.Student;
import com.nanasa.org.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ujitha on 8/20/2016.
 */

@Service
public class StudentService implements StudentMapper {

    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Override
    public void insertStudent(Student student) {
        sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getStudentById(studentId);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getAllStudents();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateStudent(Student student) {
        sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.updateStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.deleteStudent(studentId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
