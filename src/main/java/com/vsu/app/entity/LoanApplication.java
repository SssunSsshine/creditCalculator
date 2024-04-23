package com.vsu.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table (name = "LoanApplication")
public class LoanApplication {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @ManyToOne
    @JoinColumn (name = "client_id")
    private Client client;

    @Column (name = "credit_amount")
    @NotNull
    private BigDecimal creditAmount;

    @Column (name = "term")
    @NotNull
    private Integer term;

    @Column (name = "date_applied")
    @NotNull
    private LocalDateTime dateApplied;
}
