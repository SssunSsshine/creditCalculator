package com.vsu.app.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientRequest {
    @NotBlank(message = "Surname cannot be blank")
    @Pattern(regexp = "^([а-яА-ЯёЁ]+|[a-zA-Z]){1,50}", message = "Surname has wrong symbols")
    private String surname;

    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^([а-яА-ЯёЁ]+|[a-zA-Z]){1,50}", message = "Name has wrong symbols")
    private String name;

    @Pattern(regexp = "^([а-яА-ЯёЁ]+|[a-zA-Z]){1,50}", message = "Name has wrong symbols")
    private String patronymic;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotNull(message = "Date cannot be empty")
    @Past(message = "Date is not valid")
    private LocalDate birthDate;

    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    @NotBlank(message = "Marriage status cannot be blank")
    private Boolean isMarried;

    @NotBlank(message = "Parenting status cannot be blank")
    private Boolean hasKids;

    @NotBlank(message = "Dependency amount cannot be blank")
    private Integer dependencyAmount;
}
