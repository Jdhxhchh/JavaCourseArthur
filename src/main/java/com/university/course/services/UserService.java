package com.university.course.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.course.models.Expense;
import com.university.course.models.User;
import com.university.course.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ExpenseService expenseService;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    public User getUserById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public List<Expense> getExpensesByUser(Long userId) {
        List<Expense> allExpenses = expenseService.listExpenses();
        List<Expense> expenses = new ArrayList<>();

        for(Expense expense : allExpenses) {
            if(expense.getUser().getId() == userId) {
                expenses.add(expense);
            }
        }

        return expenses;
    }

    public List<User> listUsers() {
        return userRepo.findAll();
    }

    public void updateUser(User updatedUser) {
        userRepo.save(updatedUser);
    }
}
