package org.spring.boot.redis.session.config.dao;

import org.spring.boot.redis.session.config.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameAndEmail(String userName, String email);

    @Query("select user from User user where user.id = :id")
    User findById(@Param("id") Long id);
}
