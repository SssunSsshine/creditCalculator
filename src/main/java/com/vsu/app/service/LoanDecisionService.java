package com.vsu.app.service;

import com.vsu.app.entity.Contacts;
import com.vsu.app.entity.LoanDecision;
import com.vsu.app.exception.ValidationException;
import com.vsu.app.repository.LoanDecisionRepository;
import com.vsu.app.response.ContactsDto;
import com.vsu.app.response.LoanDecisionDto;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.math.BigDecimal;

@Service
public class LoanDecisionService {
        private final LoanDecisionRepository loanDecisionRepository;

        public LoanDecisionService(LoanDecisionRepository loanDecisionRepository) {
            this.loanDecisionRepository = loanDecisionRepository;
        }



//        public LoanDecision saveLoanDecision(LoanDecision loanDecision) {
//            if (loanDecision.getSuccess()) {
//                return saveSuccessful(loanDecision);
//            } else {
//                return saveDeclined(loanDecision);
//            }
//        }

        private LoanDecision saveDeclined(LoanDecision loanDecision) {
            if (isDeclined(loanDecision)) {
                if (loanDecision.getReason().isBlank()) {
                    throw new ValidationException("Reason cannot be empty");
                }
                return loanDecisionRepository.saveDeclinedDecision(loanDecision);
            } else {
                throw new ValidationException("Reason cannot be null / Rate, full amount and monthly payment must be null");
            }
        }

        private LoanDecision saveSuccessful(LoanDecision loanDecision) {
            if (isSuccessful(loanDecision)) {
                validateSuccessfulDecision(loanDecision);
                return loanDecisionRepository.saveSuccessfulDecision(loanDecision);
            } else {
                throw new ValidationException("Rate, full amount and monthly payment cannot be null / Reason must be null");
            }
        }

        private static void validateSuccessfulDecision(LoanDecision loanDecision) {
            if (loanDecision.getRate() <= 0) {
                throw new ValidationException("Rate must be greater than 0");
            }
            if (loanDecision.getMonthlyPayment().compareTo(BigDecimal.ZERO) <= 0) {
                throw new ValidationException("Monthly payment must be greater than 0");
            }
            if (loanDecision.getFullAmount().compareTo(BigDecimal.ZERO) <= 0) {
                throw new ValidationException("Full amount must be greater than 0");
            }
        }

        private static Boolean isDeclined(LoanDecision loanDecision) {
            return loanDecision.getRate() == null && loanDecision.getFullAmount() == null
                    && loanDecision.getMonthlyPayment() == null && loanDecision.getReason() != null;
        }

        private static Boolean isSuccessful(LoanDecision loanDecision) {
            return loanDecision.getRate() != null && loanDecision.getFullAmount() != null
                    && loanDecision.getMonthlyPayment() != null && loanDecision.getReason() == null;
        }

        public LoanDecisionDto getLoanDecisionById(Long id){
            return fromLoanDecisionToLoanDecisionDto(loanDecisionRepository.findById(id).orElseThrow());
        }

        public LoanDecisionDto saveLoanDecision(LoanDecision loanDecision) {
            loanDecisionRepository.save(loanDecision);
            return fromLoanDecisionToLoanDecisionDto(loanDecision);
        }

        @Transactional
        public void deleteLoanDecisionsById(Long id){
            loanDecisionRepository.deleteById(id);
        }


        @Transactional
        public LoanDecisionDto updateLoanDecision(Long id) {
            LoanDecision loanDecision = loanDecisionRepository.getById(id);
            loanDecisionRepository.save(loanDecision);
            return fromLoanDecisionToLoanDecisionDto(loanDecision);
        }

    public LoanDecisionDto fromLoanDecisionToLoanDecisionDto(LoanDecision loanDecision)
    {
        return LoanDecisionDto.builder()
                .id(loanDecision.getId())
                .loanApplication(loanDecision.getLoanApplication())
                .success(loanDecision.getSuccess())
                .reason(loanDecision.getReason())
                .fullAmount(loanDecision.getFullAmount())
                .rate(loanDecision.getRate())
                .monthlyPayment(loanDecision.getMonthlyPayment())
                .build();
    }
}
