package com.vsu.app.request;

import com.vsu.app.entity.LoanApplication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanDecisionRequest {

    @NotNull(message = "LoanApplication cannot be unassigned")
    private LoanApplication loanApplication;

    @NotNull(message = "Success cannot be blank")
    private Boolean success;
}
