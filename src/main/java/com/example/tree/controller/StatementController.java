package com.example.tree.controller;

import com.example.tree.entity.StatementEntity;
import com.example.tree.service.StatementService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statement")
public class StatementController {
    private final StatementService statementService;

    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

    @GetMapping("")
    public ResponseEntity<List<StatementEntity>> getStatement() {
        return ResponseEntity.ok().body(statementService.getStatementEntity(1L));
    }

    @GetMapping("byId")
    public ResponseEntity<List<StatementEntity>> getStatementByAccountId(@RequestParam Long accountId) {
        return ResponseEntity.ok().body(statementService.findByAccountId(accountId));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dateRange")
    public ResponseEntity<List<StatementEntity>> getStatementByAccountIdAndDate(@RequestParam Long accountId,@RequestParam String start,
    @RequestParam String end) {
        return ResponseEntity.ok().body(statementService.findByAccountIdAndDate(accountId,start,end));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/priceRange")
    public ResponseEntity<List<StatementEntity>> getStatementByAccountIdAndAmount(@RequestParam Long accountId,@RequestParam String start,
                                                                         @RequestParam String end) {
        return ResponseEntity.ok().body(statementService.findByAccountIdAndAmount(accountId,start,end));
    }
}
