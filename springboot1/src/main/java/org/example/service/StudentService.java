package org.example.service;

import org.example.model.Student;

public interface StudentService {

    Student queryStudentById(Integer id);

    int updateStudentById(Student student);
}
