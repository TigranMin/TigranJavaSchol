package com.sbt.javaschool.lessons;

import java.time.LocalDateTime;

public class Lesson {

    public Lesson(Long id, String theme, LocalDateTime lessonDate) {
        this.id = id;
        this.theme = theme;
        this.lessonDate = lessonDate;
    }

    private final Long id;
    private final String theme;
    private final LocalDateTime lessonDate;



}
