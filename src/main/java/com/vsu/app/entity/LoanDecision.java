package com.vsu.app.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "LoanDecision")
public class LoanDecision {
    @Id
    @GeneratedValue
    @NotNull
    public Long id;

    @Column(name = "application_id")
    @NotNull
    private Long applicationId;

    @Column(name = "success")
    @NotNull
    private Boolean success;

    @Column(name = "reason")
    private String reason;

    @Column(name = "full_amount")
    private BigDecimal fullAmount;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "monthly_payment")
    private BigDecimal monthlyPayment;

}