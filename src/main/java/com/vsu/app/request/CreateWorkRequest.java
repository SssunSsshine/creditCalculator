package com.vsu.app.request;

import com.vsu.app.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateWorkRequest {

    @NotNull(message = "Is Working cannot be blank")
    private Boolean isWorking;

    @NotBlank(message = "Total Seniority amount cannot be blank")
    private Integer totalSeniority;

    @NotBlank(message = "Salary amount cannot be blank")
    private BigDecimal salary;


}
