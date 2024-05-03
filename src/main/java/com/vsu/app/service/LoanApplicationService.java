package com.vsu.app.service;

import com.vsu.app.entity.LoanApplication;
import com.vsu.app.exception.ValidationException;
import com.vsu.app.repository.LoanApplicationRepository;
import com.vsu.app.response.LoanApplicationDto;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LoanApplicationService {
    private static final Logger LOGGER = Logger.getLogger(LoanApplicationService.class.getName());
    private final LoanApplicationRepository loanApplicationRepository;

    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    public LoanApplicationDto getLoanApplicationById(Long id)
    {
        return fromLoanApplicationToLoanApplicationDto(loanApplicationRepository.findById(id).orElseThrow());
    }

    public LoanApplicationDto saveLoanApplication(LoanApplication loanApplication){
        if (loanApplication.getCreditAmount().compareTo(BigDecimal.ZERO) <= 0){
            throw new ValidationException("Credit amount must be greater than 0");
        }
        if (loanApplication.getTerm() <= 0){
            throw new ValidationException("Term must be greater than 0");
        }

        loanApplicationRepository.save(loanApplication);
        return fromLoanApplicationToLoanApplicationDto(loanApplication);
    }

    @Transactional
    public void deleteLoanApplication(Long idApplication, Long idClient) {
        LoanApplication loanApplication = loanApplicationRepository.findById(idApplication).orElseThrow();
        validateApplicationForModify(idApplication, idClient, loanApplication);
        loanApplicationRepository.deleteById(idApplication);
    }

    @Transactional
    public LoanApplicationDto updateLoanApplication(Long idApplication, Long idClient) {
        LoanApplication loanApplication = loanApplicationRepository.findById(idApplication).orElseThrow();
        validateApplicationForModify(idApplication, idClient, loanApplication);
        loanApplicationRepository.save(loanApplication);
        return fromLoanApplicationToLoanApplicationDto(loanApplication);
    }

    private static void validateApplicationForModify(Long idApplication, Long idClient, LoanApplication loanApplication) {
        if (!loanApplication.getClient().getId().equals(idClient)) {
            LOGGER.log(Level.WARNING, String.format("Client with id {%s} did not make an application with id {%s}", idClient, idClient));
            throw new ValidationException("Clients ids do not match");
        }
    }



    public LoanApplicationDto fromLoanApplicationToLoanApplicationDto(LoanApplication loanApplication)
    {
        return LoanApplicationDto.builder()
                .id(loanApplication.getId())
                .client(loanApplication.getClient())
                .creditAmount(loanApplication.getCreditAmount())
                .term(loanApplication.getTerm())
                .dateApplied(loanApplication.getDateApplied())
                .build();
    }

}
