package com.vsu.app.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table (name = "LoanDecision")
public class LoanDecision {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "application_id")
    public long application_id;

    @Column(name = "success")
    public boolean success;

    @Column(name = "reason")
    public String reason;

    @Column(name = "full_amount")
    public BigDecimal full_amount;

    @Column(name = "rate")
    public int rate;

    @Column(name = "monthly_payment")
    public BigDecimal monthly_payment;

}
