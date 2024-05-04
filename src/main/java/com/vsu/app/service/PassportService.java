package com.vsu.app.service;

import com.vsu.app.entity.Passport;
import com.vsu.app.exception.ValidationException;
import com.vsu.app.repository.PassportRepository;
import org.springframework.stereotype.Service;
import com.vsu.app.response.PassportDto;

import java.time.LocalDate;

import javax.transaction.Transactional;
@Service
public class PassportService {
    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public PassportDto getPassportById(Long id){
        return fromPassportToPassportDto(passportRepository.findById(id).orElseThrow());
    }
    public PassportDto savePassport(Passport passport){
        if(passport.getIssueDate() != null && passport.getIssueDate().isAfter(LocalDate.now())){
            throw new ValidationException("Issue date cannot be in the future");
        }
        passportRepository.save(passport);
        return fromPassportToPassportDto(passport);
    }

    @Transactional
    public void deletePassportById(Long id){
        passportRepository.deleteById(id);
    }


    @Transactional
    public PassportDto updatePassport(Long id) {
        Passport passport = passportRepository.getById(id);
        passportRepository.save(passport);
        return fromPassportToPassportDto(passport);
    }

    public PassportDto fromPassportToPassportDto(Passport passport)
    {
        return PassportDto.builder()
                .id(passport.getId())
                .series(passport.getSeries())
                .number(passport.getNumber())
                .issueDate(passport.getIssueDate())
                .issuePlace(passport.getIssuePlace())
                .build();
    }
}
