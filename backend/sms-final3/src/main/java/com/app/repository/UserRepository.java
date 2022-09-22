package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from user_tbl where email=:email", nativeQuery = true)
	User findByEmail(@Param("email") String email);
}
