package com.sbt.javaschool.students;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> loadByLessonId(long lessonId) throws SQLException {
        return studentRepository.loadByLessonId(lessonId);
    }

    public Student loadById(long id) throws SQLException {
        return studentRepository.loadById(id);
    }
}
