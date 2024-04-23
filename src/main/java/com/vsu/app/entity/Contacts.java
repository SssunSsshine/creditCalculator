package com.vsu.app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Contacts")
public class Contacts {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column (name = "email", unique = true)
    @NotNull
    private String email;

    @Column (name = "phone_number", unique = true)
    @NotNull
    private String phoneNumber;

    @Column (name = "address")
    @NotNull
    private String address;

}
