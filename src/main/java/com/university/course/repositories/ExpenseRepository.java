package com.university.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.course.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}