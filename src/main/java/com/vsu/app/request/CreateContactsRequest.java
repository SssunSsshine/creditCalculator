package com.vsu.app.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateContactsRequest {
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Bad format for email")
    private String email;

    @NotBlank(message = "Phone cannot be blank")
    /*@Min(value = 11, message = "Phone should contain 11 digits")
    @Digits(message="Phone should contain 11 digits.", fraction = 0, integer = 11)*/
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Phone format is invalid")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be blank")
    private String address;
}
