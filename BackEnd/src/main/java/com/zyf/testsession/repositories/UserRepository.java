package com.zyf.testsession.repositories;

import com.zyf.testsession.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value="select password from user where username = ?1", nativeQuery=true)
    public String findPasswordByUsername(String username);
}
