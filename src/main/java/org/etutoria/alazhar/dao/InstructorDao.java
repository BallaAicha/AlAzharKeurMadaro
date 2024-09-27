package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDao extends JpaRepository<Instructor, Long> {
}
