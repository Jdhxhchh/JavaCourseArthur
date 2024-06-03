package com.university.course.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.course.models.Expense;
import com.university.course.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepo;

    public void addExpense(Expense expense) {
        expenseRepo.save(expense);
    }

    public void deleteExpense(Long expenseId) {
        expenseRepo.deleteById(expenseId);
    }

    public Expense getExpenseById(Long expenseId) {
        return expenseRepo.findById(expenseId).orElse(null);
    }

    public List<Expense> listExpenses() {
        return expenseRepo.findAll();
    }

    public void updateExpense(Expense updatedExpense) {
        expenseRepo.save(updatedExpense);
    }
}
