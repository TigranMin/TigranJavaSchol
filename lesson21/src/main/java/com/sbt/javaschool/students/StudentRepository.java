package com.sbt.javaschool.students;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {
    private static final String SELECT_BY_LESSON_ID =
            "select STUDENTS.* from STUDENTS " +
                    "join STUDENT_VISITS SV on STUDENTS.STUDENT_ID = SV.STUDENT_ID " +
                    "where LESSON_ID = :lessonId";
    public static final String SELECT_BY_ID =
            "select * from STUDENTS where STUDENT_ID = :studentId";
    public static final String INSERT =
            "insert into STUDENTS (NAME, LASTNAME) values ( :name, :lastName )";

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final StudentRowMapper studentRowMapper;

    public StudentRepository(NamedParameterJdbcTemplate jdbcTemplate, StudentRowMapper studentRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentRowMapper = studentRowMapper;
    }

    List<Student> loadByLessonId(long lessonId)  {
        return jdbcTemplate.query(SELECT_BY_LESSON_ID,
                new MapSqlParameterSource("lessonId", lessonId),
                studentRowMapper);
    }

    Student loadById(long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID,
                new MapSqlParameterSource("studentId", id),
                studentRowMapper);
    }

    void create(Student student){
        jdbcTemplate.update(
                INSERT,
                doMapping(student)
        );
    }

    private MapSqlParameterSource doMapping(Student student) {
        return new MapSqlParameterSource()
                .addValue("studentId", student.getStudentId())
                .addValue("name", student.getName())
                .addValue("lastName", student.getLastName());
    }
}
