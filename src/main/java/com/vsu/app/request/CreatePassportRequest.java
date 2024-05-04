package com.vsu.app.request;

import com.vsu.app.entity.Passport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePassportRequest {

    @NotBlank(message = "Series cannot be blank")
    private String series;

    @NotBlank(message = "Number cannot be blank")
    private String number;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotNull(message = "Issue date cannot be empty")
    @Past(message = "Issue date is not valid")
    private LocalDate issueDate;

    @NotBlank(message = "Issue place cannot be blank")
    private String issuePlace;
}
