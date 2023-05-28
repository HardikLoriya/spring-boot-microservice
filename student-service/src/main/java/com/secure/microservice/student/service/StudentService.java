package com.secure.microservice.student.service;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.secure.microservice.student.VO.Department;
import com.secure.microservice.student.VO.ResponseTemplateVO;
import com.secure.microservice.student.entity.Student;
import com.secure.microservice.student.repository.StudentRepository;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Student saveStudent(Student student) {
        log.info("Inside saveStudent of StudentService");
        return studentRepository.save(student);
    }

    public ResponseTemplateVO getStudentWithDepartment(Long studentId) {
        log.info("Inside getStudentWithDepartment of StudentService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Student student = studentRepository.findByStudentId(studentId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + student.getDepartmentId()
                        ,Department.class);

        vo.setStudent(student);
        vo.setDepartment(department);

        return  vo;
    }
}
