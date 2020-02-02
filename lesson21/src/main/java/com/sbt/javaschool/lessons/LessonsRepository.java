package com.sbt.javaschool.lessons;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class LessonsRepository {

    private static final String SELECT_BY_ID =
            "select LESSONS.* FROM LESSONS " +
            "where LESSON_ID = :lessonId";


    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final LessonRowMapper lessonRowMapper;

    public LessonsRepository(NamedParameterJdbcTemplate jdbcTemplate, LessonRowMapper lessonRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.lessonRowMapper = lessonRowMapper;
    }

    Lesson loadById(long lessonId) throws SQLException {

        return jdbcTemplate.queryForObject(SELECT_BY_ID,
                new MapSqlParameterSource("lessonId", lessonId),
                lessonRowMapper);
    }
}
