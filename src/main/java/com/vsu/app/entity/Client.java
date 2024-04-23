package com.vsu.app.entity;

import lombok.AllArgsConstructor;
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
@Table (name = "Client")
public class Client {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column (name = "passport_id")
    @NotNull
    private Long passportId;

    @Column (name = "work_id")
    @NotNull
    private Long workId;

    @Column (name = "contact_id")
    @NotNull
    private Long contactId;

    @Column (name = "name")
    @NotNull
    private String name;

    @Column (name = "surname")
    @NotNull
    private String surname;

    @Column (name = "patronymic")
    private String patronymic;

    @Column (name = "birth_date")
    @NotNull
    private LocalDate birthDate;

    @Column (name = "gender")
    @NotNull
    private String gender;

    @Column (name = "is_married")
    @NotNull
    private Boolean isMarried;

    @Column (name = "has_kids")
    @NotNull
    private Boolean hasKids;

    @Column (name = "dependency_amount")
    @NotNull
    private Integer dependencyAmount;
}
