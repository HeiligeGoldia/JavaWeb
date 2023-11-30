package com.se.nhom6.detai.repository;

import com.se.nhom6.detai.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<UserDetail, String> {

    @Modifying
    @Transactional
    @Query(value = "insert into users values (:username, :password, :enabled)", nativeQuery = true)
    void createAccount(@Param("username") String username, @Param("password") String password, @Param("enabled") int enabled);

    @Modifying
    @Transactional
    @Query(value = "insert into authorities values (:username, 'ROLE_USER')", nativeQuery = true)
    void setRole(@Param("username") String username);

}
