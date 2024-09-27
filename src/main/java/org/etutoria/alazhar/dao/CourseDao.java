package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
