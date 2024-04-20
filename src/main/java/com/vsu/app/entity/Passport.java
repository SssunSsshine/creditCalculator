package com.vsu.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table (name = "Passport")
public class Passport {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "series")
    public String series;

    @Column(name = "number")
    public String number;

    @Column(name = "issue_date")
    public LocalDate issue_date;

    @Column(name = "issue_place")
    public String issue_place;
}