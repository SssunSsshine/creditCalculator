package com.vsu.app.controller;

import com.vsu.app.entity.Client;
import com.vsu.app.request.CreateClientRequest;
import com.vsu.app.service.ClientService;
import com.vsu.app.response.ClientDto;
import com.vsu.app.service.ContactsService;
import org.hibernate.annotations.Cascade;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/{id}")
    public ClientDto getById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }


    @PostMapping("/client/insert")
    public ClientDto insert(@RequestBody @Valid CreateClientRequest clientRequest) {
        return clientService.saveClient(new Client(
                clientRequest.getSurname(),
                clientRequest.getName(),
                clientRequest.getPatronymic(),
                clientRequest.getBirthDate(),
                clientRequest.getGender(),
                clientRequest.getIsMarried(),
                clientRequest.getHasKids(),
                clientRequest.getDependencyAmount()));
    }

    @DeleteMapping("/client/delete/{id}")
    public String delete(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return "Client is deleted successfully";
    }

    @PostMapping("/client/update/{id}")
    public ClientDto update(@PathVariable Long id, @RequestBody @Valid CreateClientRequest clientRequest)
    {
        return clientService.updateClient(id);
    }
}