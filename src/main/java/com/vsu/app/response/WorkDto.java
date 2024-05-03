package com.vsu.app.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class WorkDto {
    private Long id;
    private Boolean isWorking;
    private String workAddress;
    private Integer seniority;
    private Integer totalSeniority;
    private BigDecimal salary;
}
