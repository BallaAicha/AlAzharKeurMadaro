package org.etutoria.alazhar.services.impl;

import lombok.AllArgsConstructor;

import org.etutoria.alazhar.dao.RoleDao;
import org.etutoria.alazhar.dao.UserDao;
import org.etutoria.alazhar.entities.Role;
import org.etutoria.alazhar.entities.User;
import org.etutoria.alazhar.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final RoleDao roleDao;

    @Override
    public User loadUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User createUser(String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        return userDao.save(new User(email, encodedPassword));
    }

    @Override
    public void assignRoleToUser(String email, String roleName) {
        User user = loadUserByEmail(email);
        Role role = roleDao.findByName(roleName);
        user.assignRoleToUser(role);
    }
}