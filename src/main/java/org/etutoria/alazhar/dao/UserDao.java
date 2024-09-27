package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
