package org.spring.data.jpa.test.dao;

import org.spring.data.jpa.test.entity.User;
import org.spring.data.jpa.test.enums.UserType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 分页查询.
     *
     * @param pageable
     * @return
     */
    @Override
    Page<User> findAll(Pageable pageable);

    /**
     * 分页查询.
     *
     * @param userName
     * @param pageable
     * @return
     */
    Page<User> findByUserName(String userName, Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update User u set u.userName = :userName, u.userType = :userType where u.id = :userId")
    int modifyUserNameByUserId(@Param("userName") String userName, @Param("userType") UserType userType, @Param("userId") Long id);
}
