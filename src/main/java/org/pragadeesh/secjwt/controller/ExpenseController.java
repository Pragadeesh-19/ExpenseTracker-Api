package org.pragadeesh.secjwt.controller;

import org.pragadeesh.secjwt.model.Expense;
import org.pragadeesh.secjwt.model.User;
import org.pragadeesh.secjwt.service.CustomUserDetailsSevice;
import org.pragadeesh.secjwt.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final CustomUserDetailsSevice customUserDetailsSevice;
    @Autowired
    public ExpenseController(ExpenseService expenseService, CustomUserDetailsSevice customUserDetailsSevice) {
        this.expenseService = expenseService;
        this.customUserDetailsSevice = customUserDetailsSevice;
    }

    @GetMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = getCurrentUser(authentication);

        expense.setUser(user);
        Expense addedExpense = expenseService.addExpense(expense);
        return new ResponseEntity<>(addedExpense, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Expense>> getExpense(@RequestParam(required = false) String category,
                                                    @RequestParam(required = false) LocalDate startDate,
                                                    @RequestParam(required = false) LocalDate endDate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = getCurrentUser(authentication);
        List<Expense> expenses;

        if(category != null) {
            expenses = expenseService.getExpenseByCategory(currentUser.getId(), category);
        } else {
            expenses = expenseService.getExpense(currentUser.getId(), startDate, endDate);
        }

        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id,
                                                 @RequestBody Expense expense) {
        expense.setId(id);

        Expense updatedExpense = expenseService.updateExpense(expense);
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private User getCurrentUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return (User) customUserDetailsSevice.loadUserByUsername(userDetails.getUsername());
    }

}
