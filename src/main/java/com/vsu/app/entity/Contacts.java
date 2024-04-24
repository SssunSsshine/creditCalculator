package com.vsu.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@Entity
@Table (name = "Contacts")
public class Contacts {
    @Id
    @GeneratedValue
    @Column(name = "contacts_id")
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
