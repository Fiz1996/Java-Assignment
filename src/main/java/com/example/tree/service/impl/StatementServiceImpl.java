package com.example.tree.service.impl;

import com.example.tree.entity.StatementEntity;
import com.example.tree.repository.StatementRepository;
import com.example.tree.service.StatementService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return statementRepository.findByAccountId(accountId).orElse(null);
    }

    public List<StatementEntity> findByAccountIdAndDate(Long accountId , String start, String end) {
        return statementRepository.findByAccountIdAndDateRange(accountId,start,end).orElse(null);
    }

    public List<StatementEntity> findByAccountIdAndAmount (Long accountId, String startingAmount, String endingAmount) {
        return statementRepository.findByAccountIdAndAmountRange(accountId,startingAmount,endingAmount).orElse(null);
    }
}
