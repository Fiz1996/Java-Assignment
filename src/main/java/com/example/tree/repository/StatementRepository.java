package com.example.tree.repository;

import com.example.tree.entity.StatementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface StatementRepository extends JpaRepository<StatementEntity,Long> {

    @Query(value = "select * from statement where account_id = :id and datefield between :start and :end",nativeQuery = true)
    Optional <List<StatementEntity>> findByAccountId(@Param("id") Long Id, @Param("start") LocalDateTime start, LocalDateTime end);

    @Query(value = "select * from statement where account_id = :id and datefield between :start and :end"
            ,nativeQuery = true)
    Optional <List<StatementEntity>> findByAccountIdAndDateRange(@Param("id") Long Id,@Param("start") String start,
                                                                 @Param("end") String end);

    @Query(value = "select * from statement where account_id = :id and  amount between :start and :end"
            ,nativeQuery = true)
    Optional <List<StatementEntity>> findByAccountIdAndAmountRange(@Param("id") Long Id , @Param("start") String start,
    @Param("end") String end );
}
