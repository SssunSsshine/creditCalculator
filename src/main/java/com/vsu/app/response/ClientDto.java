package com.vsu.app.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.vsu.app.entity.LoanApplication;
import com.vsu.app.entity.Passport;
import com.vsu.app.entity.Work;
import com.vsu.app.repository.ClientRepository;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClientDto {
    private Long id;
    private Passport passport;
    private Work work;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    private String gender;
    private Boolean isMarried;
    private Boolean hasKids;
    private Integer dependencyAmount;
    private List<LoanApplication> loanApplications;
}
