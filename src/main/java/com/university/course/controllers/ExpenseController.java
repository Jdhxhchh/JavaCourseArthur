package com.university.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.course.controllers.dtos.ExpenseRequest;
import com.university.course.models.Expense;
import com.university.course.services.ExpenseService;
import com.university.course.services.UserService;



@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<Expense>> list() {
        return ResponseEntity.ok(expenseService.listExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> byId(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Expense> put(@PathVariable Long id, @RequestBody ExpenseRequest expenseRequest) {
        Expense expense = new Expense();
        expense.setId(id);
        expense.setDescription(expenseRequest.getDescription());
        expense.setAmount(expenseRequest.getAmount());
        expense.setDate(expenseRequest.getDate());
        expense.setUser(userService.getUserById(expenseRequest.getUser_id()));

        expenseService.updateExpense(expense);
        return ResponseEntity.ok(expense);
    }

    @PostMapping("/")
    public ResponseEntity<Expense> add(@RequestBody ExpenseRequest expenseRequest) {
        Expense expense = new Expense();
        expense.setDescription(expenseRequest.getDescription());
        expense.setAmount(expenseRequest.getAmount());
        expense.setDate(expenseRequest.getDate());
        expense.setUser(userService.getUserById(expenseRequest.getUser_id()));

        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
