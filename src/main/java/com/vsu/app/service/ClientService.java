package com.vsu.app.service;

import com.vsu.app.entity.Client;
import com.vsu.app.entity.LoanApplication;
import com.vsu.app.entity.Passport;
import com.vsu.app.entity.Work;
import com.vsu.app.exception.ValidationException;
import com.vsu.app.repository.ClientRepository;
import com.vsu.app.response.ClientDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//Здесь надо переделать когда появятся классы DTO
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public ClientDto saveClient(Client client) {
//        Work work = client.getWork();
//        if (work.getIsWorking() && (work.getWorkAddress() == null || work.getSeniority() == null)) {
//            throw new ValidationException("The address and seniority field must be filled in if the client is working");
//        }
//        if (client.getBirthDate() != null && client.getBirthDate().isAfter(LocalDate.now())) {
//            throw new ValidationException("The date of birth cannot be in the future");
//        }
        clientRepository.save(client);
        return fromClientToClientDto(client);
    }

    public ClientDto getClientById(Long id){
        return fromClientToClientDto(clientRepository.findById(id).orElseThrow());
    }

    @Transactional
    public void deleteClientById(Long id){
        clientRepository.deleteById(id);
    }

    @Transactional
    public ClientDto updateClient(Long id) {
        Client client = clientRepository.getById(id);
        clientRepository.save(client);
        return fromClientToClientDto(client);
    }


    public ClientDto fromClientToClientDto(Client client)
    {
        return ClientDto.builder()
                .id(client.getId())
                .surname(client.getSurname())
                .name(client.getName())
                .patronymic(client.getPatronymic())
                .passport(client.getPassport())
                .work(client.getWork())
                .birthDate(client.getBirthDate())
                .gender(client.getGender())
                .isMarried(client.getIsMarried())
                .hasKids(client.getHasKids())
                .dependencyAmount(client.getDependencyAmount())
                .loanApplications(client.getLoanApplications())
                .build();
}
}
