package com.vsu.app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table (name = "Contacts")
public class Contacts {
    @Id
    @GeneratedValue
    public Long id;

    @Column (name = "email")
    public String email;

    @Column (name = "phone_number")
    public String phone_number;

    @Column (name = "address")
    public String address;

}