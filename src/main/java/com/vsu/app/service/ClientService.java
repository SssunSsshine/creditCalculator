package com.vsu.app.service;

import com.vsu.app.entity.Client;
import com.vsu.app.entity.Work;
import com.vsu.app.exception.ValidationException;
import com.vsu.app.repository.ClientRepository;
import com.vsu.app.response.ClientDto;
import org.springframework.stereotype.Service;

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

    public ClientDto saveClient(Client client) {
        Work work = client.getWork();
        if (work.getIsWorking() && (work.getWorkAddress() == null || work.getSeniority() == null)) {
            throw new ValidationException("The address and seniority field must be filled in if the client is working");
        }
        if (client.getBirthDate() != null && client.getBirthDate().isAfter(LocalDate.now())) {
            throw new ValidationException("The date of birth cannot be in the future");
        }

        clientRepository.save(client);
        return new ClientDto();
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id){
        return clientRepository.findById(id);
    }

    public void deleteClientById(Long id){
        clientRepository.deleteById(id);
    }
}
