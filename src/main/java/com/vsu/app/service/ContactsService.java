package com.vsu.app.service;

import com.vsu.app.entity.Contacts;
import com.vsu.app.repository.ContactsRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactsService {
    private final ContactsRepository contactsRepository;

    public ContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public Contacts saveContacts(Contacts contacts){
        return contactsRepository.save(contacts);
    }
}
