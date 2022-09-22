package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entities.Class;

public interface ClassRepository extends JpaRepository<Class, Integer> {

}
