package com.vsu.app.request;

import com.vsu.app.entity.Client;
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
public class CreateLoanApplicationRequest {

    @NotNull(message = "Client cannot be unassigned")
    private Client client;

    @NotBlank(message = "Credit amount cannot be blank")
    private BigDecimal creditAmount;

    @NotNull(message = "Term cannot be blank")
    private Integer term;


}
