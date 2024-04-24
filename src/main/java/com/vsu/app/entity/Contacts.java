package com.vsu.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not valid")
    private String email;

    @Column (name = "phone_number", unique = true)
    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\+\\d{11}+$", message = "Phone number is not valid")
    private String phoneNumber;

    @Column (name = "address")
    @NotBlank(message = "Address is mandatory")
    private String address;
}
