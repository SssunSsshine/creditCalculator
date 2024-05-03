package com.vsu.app.controller;


import com.vsu.app.entity.LoanApplication;
import com.vsu.app.request.CreateLoanApplicationRequest;
import com.vsu.app.response.LoanApplicationDto;
import com.vsu.app.service.LoanApplicationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoanApplicationController {
    private final LoanApplicationService loanApplicationService;

    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @GetMapping("/loanApplication/{id}")
    public LoanApplicationDto getById(@PathVariable  Long id)
    {
        return loanApplicationService.getLoanApplicationById(id);
    }

    @PostMapping("/loanApplication/insert")
    public LoanApplicationDto insert(@RequestBody @Valid CreateLoanApplicationRequest loanApplication)
    {
        return loanApplicationService.saveLoanApplication(new LoanApplication(
                loanApplication.getClient(),
                loanApplication.getCreditAmount(),
                loanApplication.getTerm()
        ));
    }

    @DeleteMapping("clients/{idClient}/loanApplication/delete/{idMessage}")
    public String delete(@PathVariable Long idApplication, @PathVariable Long idClient)
    {
        loanApplicationService.deleteLoanApplication(idApplication, idClient);
        return "Loan application was deleted successfully";
    }

    @PostMapping("clients/{idClient}/loanApplication/update/{idMessage}")
    public LoanApplicationDto update(@PathVariable Long idApplication, @PathVariable Long idClient, @RequestBody @Valid CreateLoanApplicationRequest applicationRequest)
    {
        return loanApplicationService.updateLoanApplication(idApplication, idClient);
    }


}
