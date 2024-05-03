package com.vsu.app.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PassportDto {
    private Long id;
    private String series;
    private String number;
    private LocalDate issueDate;
    private String issuePlace;

}
