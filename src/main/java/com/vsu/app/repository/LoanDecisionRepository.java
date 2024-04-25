package com.vsu.app.repository;

import com.vsu.app.entity.LoanDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LoanDecisionRepository extends JpaRepository<LoanDecision, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO loan_decision (application_id, success, full_amount, rate, monthly_payment) " +
            "VALUES (:#{#loanDecision.applicationId}, :#{#loanDecision.success}, " +
            ":#{#loanDecision.fullAmount}, :#{#loanDecision.rate}, :#{#loanDecision.monthlyPayment})", nativeQuery = true)
    LoanDecision saveSuccessfulDecision(LoanDecision loanDecision);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO loan_decision (application_id, success, reason) " +
            "VALUES (:#{#loanDecision.applicationId}, :#{#loanDecision.success}, " +
            ":#{#loanDecision.reason})", nativeQuery = true)
    LoanDecision saveDeclinedDecision(LoanDecision loanDecision);
}
