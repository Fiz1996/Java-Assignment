package com.example.tree.service.impl;

import com.example.tree.entity.StatementEntity;
import com.example.tree.repository.StatementRepository;
import com.example.tree.service.StatementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class StatementServiceImpl implements StatementService {

    private final StatementRepository statementRepository;

    public StatementServiceImpl(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    @Override
    public List<StatementEntity> getStatementEntity(Long id) {
     return    statementRepository.findAll();
    }

    public List<StatementEntity> findByAccountId(Long accountId) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime threeMonthsBefore = today.minusMonths(3);
        return statementRepository.findByAccountId(accountId,today,threeMonthsBefore).orElse(null);
    }

    public List<StatementEntity> findByAccountIdAndDate(Long accountId , String start, String end) {
        return statementRepository.findByAccountIdAndDateRange(accountId,start,end).orElse(null);
    }

    public List<StatementEntity> findByAccountIdAndAmount (Long accountId, String startingAmount, String endingAmount) {
        return statementRepository.findByAccountIdAndAmountRange(accountId,startingAmount,endingAmount).orElse(null);
    }
}
