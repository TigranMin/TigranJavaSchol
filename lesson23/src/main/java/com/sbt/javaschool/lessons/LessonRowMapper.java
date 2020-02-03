package com.sbt.javaschool.lessons;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LessonRowMapper implements RowMapper<Lesson> {

    @Override
    public Lesson mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Lesson(
                resultSet.getLong("ID"), resultSet.getString("THEME"),
                resultSet.getTimestamp("LESSONDATE").toLocalDateTime()
        );
    }
}
