/*
 *
 * You can use the following import statemets
 *
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

package com.example.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.school.model.Student;
import com.example.school.service.StudentH2Service;

@RestController
public class StudentController
{
    @Autowired
    private StudentH2Service service;

    @GetMapping("/students")
    public ArrayList<Student> getStudents()
    {
        return service.getStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId)
    {
        return service.getStudentById(studentId);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student)
    {
        return service.addStudent(student);
    }

    @PostMapping("/students/bulk")
    public Student addStudents(@RequestBody ArrayList<Student> student)
    {
        return service.addStudents(student);
    }

    @PutMapping("/students/{studentId}")
    public Student updatStudent(@PathVariable("studentId") int studentId,@RequestBody Student student)
    {
        return service.updateStudent(studentId, student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId)
    {
        service.deleteStudent(studentId);
    }
}