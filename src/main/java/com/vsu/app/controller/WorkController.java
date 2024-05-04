package com.vsu.app.controller;

import com.vsu.app.entity.Work;
import com.vsu.app.request.CreateWorkRequest;
import com.vsu.app.response.WorkDto;
import com.vsu.app.service.WorkService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class WorkController {
    private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping("/work/{id}")
    public WorkDto getById(@PathVariable Long id) {
        return workService.getWorkById(id);
    }

    @PostMapping("/work/insert")
    public WorkDto insert(@RequestBody @Valid CreateWorkRequest workRequest)
    {
        return workService.saveWork(new Work(
                workRequest.getIsWorking(),
                workRequest.getTotalSeniority(),
                workRequest.getSalary()));
    }

    @PostMapping("/work/insert/{id}")
    public WorkDto update(@PathVariable Long id,@RequestBody @Valid CreateWorkRequest workRequest) {
        return workService.updateWork(id);
    }

    @DeleteMapping("/work/delete/{id}")
    public String delete(@PathVariable Long id) {
        workService.deleteWorkById(id);
        return "Work is deleted successfully";
    }
}
