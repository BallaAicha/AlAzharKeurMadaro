package org.etutoria.alazhar.services;


import org.etutoria.alazhar.entities.User;

public interface UserService {
    User loadUserByEmail(String email);

    User createUser(String email, String password);

    void assignRoleToUser(String email, String roleName);
}
