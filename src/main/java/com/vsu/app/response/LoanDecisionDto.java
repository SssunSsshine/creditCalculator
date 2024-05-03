package com.vsu.app.response;

import com.vsu.app.entity.LoanApplication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoanDecisionDto {
    public Long id;
    private LoanApplication loanApplication;
    private Boolean success;
    private String reason;
    private BigDecimal fullAmount;
    private Integer rate;
    private BigDecimal monthlyPayment;
}
