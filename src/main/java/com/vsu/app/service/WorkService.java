package com.vsu.app.service;

import com.vsu.app.entity.Work;
import com.vsu.app.exception.ValidationException;
import com.vsu.app.repository.WorkRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkService {
    private final WorkRepository workRepository;

    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    public Work saveWork(Work work) {
        if (work.getIsWorking()) {
            validateEmployed(work);
            return workRepository.saveEmployed(work);
        } else {
            validateUnemployed(work);
            return workRepository.saveUnemployed(work);
        }
    }

    private static void validateUnemployed(Work work) {
        if(work.getSeniority() != null){
            throw new ValidationException("Work seniority must be null if client is unemployed");
        }
        if (work.getWorkAddress() == null) {
            throw new ValidationException("Work address must be null if client is unemployed");
        }
    }

    private static void validateEmployed(Work work) {
        if (work.getWorkAddress() == null) {
            throw new ValidationException("Work address cannot be null if client is employed");
        }
        if (work.getSeniority() == null) {
            throw new ValidationException("Work seniority cannot be null if client is employed");
        }
    }
}
