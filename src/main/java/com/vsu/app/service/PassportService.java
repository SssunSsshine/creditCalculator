package com.vsu.app.service;

import com.vsu.app.entity.Passport;
import com.vsu.app.exception.ValidationException;
import com.vsu.app.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PassportService {
    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public Passport savePassport(Passport passport){
        if(passport.getIssueDate() != null && passport.getIssueDate().isAfter(LocalDate.now())){
            throw new ValidationException("Issue date cannot be in the future");
        }
        return passportRepository.save(passport);
    }
}
