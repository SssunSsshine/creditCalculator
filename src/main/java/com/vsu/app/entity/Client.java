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

@NoArgsConstructor
@Data
@Entity
@Table (name = "Client")
public class Client {
    @Id
    @GeneratedValue
    public Long id;

    @Column (name = "passport_id")
    public long passport_id;

    @Column (name = "work_id")
    public long work_id;

    @Column (name = "contact_id")
    public long contact_id;

    @Column (name = "name")
    public String name;

    @Column (name = "surname")
    public String surname;

    @Column (name = "patronymic")
    public String patronymic;

    @Column (name = "birth_date")
    public LocalDate birth_date;

    @Column (name = "gender")
    public String gender;

    @Column (name = "is_married")
    public boolean is_married;

    @Column (name = "has_kids")
    public boolean has_kids;

    @Column (name = "dependency_amount")
    public int dependency_amount;
}
