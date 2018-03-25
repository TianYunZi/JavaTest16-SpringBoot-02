package org.spring.boot.security.practise.dao;

import org.spring.boot.security.practise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String userName);
}
