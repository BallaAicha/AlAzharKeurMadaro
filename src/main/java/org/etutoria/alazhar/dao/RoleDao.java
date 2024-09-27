package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
