package com.vsu.app.service;

import com.vsu.app.entity.Work;
import com.vsu.app.exception.ValidationException;
import com.vsu.app.repository.WorkRepository;
import com.vsu.app.response.PassportDto;
import com.vsu.app.response.WorkDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WorkService {
    private final WorkRepository workRepository;

    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    public WorkDto getWorkById(Long id){
        return fromWorkToWorkDto(workRepository.findById(id).orElseThrow());
    }

    public WorkDto saveWork(Work work) {
        if (work.getIsWorking()) {
            validateEmployed(work);
            workRepository.saveEmployed(work);
        } else {
            validateUnemployed(work);
            workRepository.saveUnemployed(work);
        }
        return fromWorkToWorkDto(work);
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

    @Transactional
    public void deleteWorkById(Long id){
        workRepository.deleteById(id);
    }

    @Transactional
    public WorkDto updateWork(Long id) {
        Work work = workRepository.getById(id);
        workRepository.save(work);
        return fromWorkToWorkDto(work);
    }
    public WorkDto fromWorkToWorkDto(Work work)
    {
        return WorkDto.builder()
                .id(work.getId())
                .isWorking(work.getIsWorking())
                .workAddress(work.getWorkAddress())
                .seniority(work.getSeniority())
                .totalSeniority(work.getTotalSeniority())
                .salary(work.getSalary())
                .build();
    }
}
