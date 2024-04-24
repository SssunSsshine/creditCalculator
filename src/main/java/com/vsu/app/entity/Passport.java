package com.vsu.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@Entity
@Table (name = "Passport")
public class Passport {
    @Id
    @GeneratedValue
    @Column(name = "passport_id")
    @NotNull
    private Long id;

    @Column(name = "series")
    @NotNull
    private String series;

    @Column(name = "number")
    @NotNull
    private String number;

    @Column(name = "issue_date")
    @NotNull
    private LocalDate issueDate;

    @Column(name = "issue_place")
    @NotNull
    private String issuePlace;
}
