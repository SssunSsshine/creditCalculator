package com.vsu.app.response;

import com.vsu.app.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoanApplicationDto {
    private Long id;
    private Client client;
    private BigDecimal creditAmount;
    private Integer term;
    private Timestamp dateApplied;
}
