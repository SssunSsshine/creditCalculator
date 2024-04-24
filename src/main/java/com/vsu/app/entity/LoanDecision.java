package com.vsu.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@Entity
@Table (name = "LoanDecision")
public class LoanDecision {
    @Id
    @GeneratedValue
    @Column(name = "decision_id")
    @NotNull
    public Long id;

    @OneToOne
    @JoinColumn(name = "application_id", referencedColumnName = "application_id")
    @NotNull
    private LoanApplication loanApplication;

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