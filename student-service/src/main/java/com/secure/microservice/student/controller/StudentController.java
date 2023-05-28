package com.secure.microservice.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.microservice.student.VO.ResponseTemplateVO;
import com.secure.microservice.student.entity.Student;
import com.secure.microservice.student.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student) {
        log.info("Inside saveStudent of StudentController");
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getStudentWithDepartment(@PathVariable("id") Long studentId) {
        log.info("Inside getStudentWithDepartment of StudentController");
        return studentService.getStudentWithDepartment(studentId);
    }


}
