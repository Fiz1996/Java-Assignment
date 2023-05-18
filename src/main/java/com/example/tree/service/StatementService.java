package com.example.tree.service;

import com.example.tree.entity.StatementEntity;

import java.util.List;

public interface StatementService {
    List<StatementEntity> getStatementEntity(Long id);
    List<StatementEntity> findByAccountId(Long accountId);

    List<StatementEntity> findByAccountIdAndDate(Long accountId,String start, String end);
    List<StatementEntity> findByAccountIdAndAmount(Long accountId,String start, String end);

}
