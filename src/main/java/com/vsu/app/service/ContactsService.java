package com.vsu.app.service;


import com.vsu.app.entity.Client;
import com.vsu.app.entity.Contacts;
import com.vsu.app.entity.Work;
import com.vsu.app.exception.ValidationException;
import com.vsu.app.repository.ContactsRepository;
import com.vsu.app.response.ClientDto;
import com.vsu.app.response.ContactsDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class ContactsService {
    private final ContactsRepository contactsRepository;

    public ContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }


    public ContactsDto getContactsById(Long id){
        return fromContactsToContactsDto(contactsRepository.findById(id).orElseThrow());
    }

    public ContactsDto saveContacts(Contacts contacts) {
        contactsRepository.save(contacts);
        return fromContactsToContactsDto(contacts);
    }

    @Transactional
    public void deleteContactsById(Long id){
        contactsRepository.deleteById(id);
    }


    @Transactional
    public ContactsDto updateContacts(Long id) {
        Contacts contacts = contactsRepository.getById(id);
        contactsRepository.save(contacts);
        return fromContactsToContactsDto(contacts);
    }


    public ContactsDto fromContactsToContactsDto(Contacts contacts)
    {
        return ContactsDto.builder()
                .id(contacts.getId())
                .email(contacts.getEmail())
                .phoneNumber(contacts.getPhoneNumber())
                .address(contacts.getAddress())
                .build();
    }
}
