package com.vsu.app.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table (name = "Work")
public class Work {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "is_working")
    public boolean is_working;

    @Column(name = "work_address")
    public String work_address;

    @Column(name = "seniority")
    public int seniority;

    @Column(name = "total_seniority")
    public int total_seniority;

    @Column(name = "salary")
    public BigDecimal salary;
}