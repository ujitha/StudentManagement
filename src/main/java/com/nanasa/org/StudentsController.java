package com.nanasa.org;

import com.nanasa.org.models.Student;
import com.nanasa.org.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", headers = "Accept=application/json")
    public void addStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", headers = "Accept=application/json")
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}