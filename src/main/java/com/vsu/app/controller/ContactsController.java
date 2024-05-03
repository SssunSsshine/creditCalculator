package com.vsu.app.controller;

import com.vsu.app.entity.Contacts;
import com.vsu.app.request.CreateContactsRequest;
import com.vsu.app.service.ContactsService;
import com.vsu.app.response.ContactsDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ContactsController {
    private final ContactsService contactsService;

    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping("/contacts/{id}")
    public ContactsDto getById(@PathVariable Long id) {
        return contactsService.getContactsById(id);
    }

    @PostMapping("/contacts/insert")
    public ContactsDto insert(@RequestBody @Valid CreateContactsRequest contactsRequest)
    {
        return contactsService.saveContacts(new Contacts(
                contactsRequest.getEmail(),
                contactsRequest.getPhoneNumber(),
                contactsRequest.getAddress()));
    }

    @PostMapping("/contacts/insert/{id}")
    public ContactsDto update(@PathVariable Long id,@RequestBody @Valid CreateContactsRequest userRequest) {
        return contactsService.updateContacts(id);
    }

    @DeleteMapping("/client/delete/{id}")
    public String delete(@PathVariable Long id) {
        contactsService.deleteContactsById(id);
        return "Contacts are deleted successfully";
    }
}


