package com.vsu.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table (name = "LoanApplication")
public class LoanApplication {
    @Id
    @GeneratedValue
    public Long id;

    @Column (name = "client_id")
    public long client_id;

    @Column (name = "credit_amount")
    public BigDecimal credit_amount;

    @Column (name = "term")
    public int term;

    @Column (name = "date_applied")
    public LocalDateTime date_applied;
}