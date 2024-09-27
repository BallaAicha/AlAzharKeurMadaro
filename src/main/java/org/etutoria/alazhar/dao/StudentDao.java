package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
}
