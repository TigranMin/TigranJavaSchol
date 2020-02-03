package com.sbt.javaschool.lessons;

import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LessonService {
    private final LessonsRepository lessonsRepository;

    public LessonService(LessonsRepository lessonsRepository) {
        this.lessonsRepository = lessonsRepository;
    }

    public Lesson loadById(long lessonId) throws SQLException {
        return lessonsRepository.loadById(lessonId);
    }
}
