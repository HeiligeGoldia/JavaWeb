package com.se.nhom6.detai.repository;

import com.se.nhom6.detai.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, String> {

    UserDetail findByEmail(String email);

    UserDetail findByPhone(String phone);

    @Query(value = "update user_details set name=:name, address=:address where username=:username", nativeQuery = true)
    @Modifying
    @Transactional
    void edit(@Param("name") String name, @Param("address") String address, @Param("username") String username);

}
