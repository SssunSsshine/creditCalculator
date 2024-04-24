package com.vsu.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@Entity
@Table (name = "Client")
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "client_id")
    @NotNull
    private Long id;

    @OneToOne
    @JoinColumn(name = "passport_id", referencedColumnName = "passport_id")
    @NotNull
    private Passport passport;

    @OneToOne
    @JoinColumn(name = "work_id", referencedColumnName = "work_id")
    @NotNull
    private Work work;

    @OneToOne
    @JoinColumn(name = "contacts_id", referencedColumnName = "contacts_id")
    @NotNull
    private Contacts contacts;

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

    @OneToMany(mappedBy = "client")
    private List<LoanApplication> loanApplications;
}
