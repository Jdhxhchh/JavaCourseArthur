package com.university.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.course.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
