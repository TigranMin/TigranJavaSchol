create table if not exists lessons
(
    lesson_id   bigint auto_increment primary key,
    theme       varchar,
    lesson_date timestamp
);

create table if not exists students
(
    student_id bigint auto_increment primary key,
    name       varchar,
    last_name  varchar
);

create table if not exists student_visits
(
    student_id bigint references students (student_id),
    lesson_id  bigint references lessons (lesson_id)
);