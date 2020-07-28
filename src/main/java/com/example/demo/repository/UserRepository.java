package com.example.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.logs.UniqLogs;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    @Transactional
    @Query(value = "select * from users u where u.id in (select user_id from user_roles where role_id = '2')", nativeQuery = true)
    List<User> getBusiness();
    @Transactional
    @Query(value = "select * from users u where u.id in (select user_id from user_roles where role_id = '1')", nativeQuery = true)
    List<User> getUser();
    @Transactional
    @Query(value = "select * from users u where u.id in (select user_id from user_roles where role_id = '3')", nativeQuery = true)
    List<User> getAdmin();
    @Transactional
    @Query(value = "select * from users u where u.username = :username ", nativeQuery = true)
    User getUserEmail(@Param("username") String username);
}
