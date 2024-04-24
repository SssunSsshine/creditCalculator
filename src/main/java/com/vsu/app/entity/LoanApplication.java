package com.vsu.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Entity
@Table (name = "LoanApplication")
public class LoanApplication {
    @Id
    @GeneratedValue
    @Column(name = "application_id")
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
