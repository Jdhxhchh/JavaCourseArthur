package com.university.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.course.services.ExpenseService;
import com.university.course.services.UserService;



@RestController
@RequestMapping("/tracker")
public class ExpenseTrackerController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> userId(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getExpensesByUser(id));
    }
    
}

