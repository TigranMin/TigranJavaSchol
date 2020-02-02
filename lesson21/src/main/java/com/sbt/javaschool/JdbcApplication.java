package com.sbt.javaschool;

import com.sbt.javaschool.students.Student;
import com.sbt.javaschool.students.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@Configuration
public class JdbcApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JdbcApplication.class, args);
        StudentService studentService = context.getBean(StudentService.class);
        studentService.create(new Student(null, "name","last name"));
        studentService.loadById(1L);
    }
}
