package com.vsu.app.controller;

import com.vsu.app.service.ClientService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    /*
    @PostMapping("/client/insert")
    public ClientDto insert(@RequestBody @Valid CreateClientRequest clienRequest){

    }*/
}
