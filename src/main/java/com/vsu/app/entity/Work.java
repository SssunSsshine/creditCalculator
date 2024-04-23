package com.vsu.app.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Work")
public class Work {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "is_working")
    @NotNull
    private Boolean isWorking;

    @Column(name = "work_address")
    private String workAddress;

    @Column(name = "seniority")
    private Integer seniority;

    @Column(name = "total_seniority")
    @NotNull
    private Integer totalSeniority;

    @Column(name = "salary")
    @NotNull
    private BigDecimal salary;
}
