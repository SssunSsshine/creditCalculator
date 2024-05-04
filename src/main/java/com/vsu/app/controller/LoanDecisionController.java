package com.vsu.app.controller;


import com.vsu.app.entity.LoanDecision;
import com.vsu.app.request.CreateLoanDecisionRequest;
import com.vsu.app.response.LoanDecisionDto;
import com.vsu.app.service.LoanDecisionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoanDecisionController {
    private final LoanDecisionService loanDecisionDtoService;

    public LoanDecisionController(LoanDecisionService loanDecisionService) {
        this.loanDecisionDtoService = loanDecisionService;
    }

    @GetMapping("/loanDecision/{id}")
    public LoanDecisionDto getById(@PathVariable  Long id)
    {
        return loanDecisionDtoService.getLoanDecisionById(id);
    }

    @PostMapping("/loanDecision/insert")
    public LoanDecisionDto insert(@RequestBody @Valid CreateLoanDecisionRequest loanDecision)
    {
        return loanDecisionDtoService.saveLoanDecision(new LoanDecision(
                loanDecision.getLoanApplication(),
                loanDecision.getSuccess()
        ));
    }

    @DeleteMapping("/loanDecision/{idLoanDecision}/{id}")
    public String delete(@PathVariable Long idDecision, @PathVariable Long idLoanApplication)
    {
        loanDecisionDtoService.deleteLoanDecisionsById(idDecision);
        return "Loan decision was deleted successfully";
    }

    @PostMapping("/loanDecision/update/{id}")
    public LoanDecisionDto update(@PathVariable Long idDecision, @PathVariable Long idLoanApplication, @RequestBody @Valid CreateLoanDecisionRequest decisionRequest)
    {
        return loanDecisionDtoService.updateLoanDecision(idDecision);
    }

}
