package com.example.tree.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "statement")
public class StatementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID ;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "datefield")
    private String datefield;

    @Column(name="amount")
    private String amount;

}
