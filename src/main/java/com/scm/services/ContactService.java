package com.scm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scm.entities.Contact;

@Service
public interface ContactService {
    // save contacts
    Contact save(Contact contact);

    // update contacts
    Contact update(Contact contact);

    // get contacts
    List<Contact> getAll();

    Contact getById(String id);

    void delete(String id);

    List<Contact> search(String name);
}
