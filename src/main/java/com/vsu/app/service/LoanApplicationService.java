package com.vsu.app.service;

import com.vsu.app.entity.LoanApplication;
import com.vsu.app.exception.ValidationException;
import com.vsu.app.repository.LoanApplicationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LoanApplicationService {
    private final LoanApplicationRepository loanApplicationRepository;

    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    public LoanApplication saveLoanApplication(LoanApplication loanApplication){
        if (loanApplication.getCreditAmount().compareTo(BigDecimal.ZERO) <= 0){
            throw new ValidationException("Credit amount must be greater than 0");
        }
        if (loanApplication.getTerm() <= 0){
            throw new ValidationException("Term must be greater than 0");
        }
        return loanApplicationRepository.save(loanApplication);
    }
}
