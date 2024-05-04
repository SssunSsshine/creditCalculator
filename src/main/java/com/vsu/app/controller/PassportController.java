package com.vsu.app.controller;

import com.vsu.app.entity.Passport;
import com.vsu.app.request.CreatePassportRequest;
import com.vsu.app.response.PassportDto;
import com.vsu.app.service.PassportService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PassportController {
    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping("/passport/{id}")
    public PassportDto getById(@PathVariable Long id) {
        return passportService.getPassportById(id);
    }

    @PostMapping("/passport/insert")
    public PassportDto insert(@RequestBody @Valid CreatePassportRequest passportRequest)
    {
        return passportService.savePassport(new Passport(
                passportRequest.getSeries(),
                passportRequest.getNumber(),
                passportRequest.getIssueDate(),
                passportRequest.getIssuePlace()));
    }

    @PostMapping("/passport/insert/{id}")
    public PassportDto update(@PathVariable Long id,@RequestBody @Valid CreatePassportRequest passportRequest) {
        return passportService.updatePassport(id);
    }

    @DeleteMapping("/passport/delete/{id}")
    public String delete(@PathVariable Long id) {
        passportService.deletePassportById(id);
        return "Passport is deleted successfully";
    }
}
