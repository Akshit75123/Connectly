package com.scm.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.scm.entities.Contact;
import com.scm.entities.User;

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

    Page<Contact> searchByName(String nameKeyword, int size, int page, String soryBy, String direction, User user);

    Page<Contact> searchByEmail(String emailKeyword, int size, int page, String soryBy, String direction, User user);

    Page<Contact> searchByPhoneNumber(String phoneNumberKeyword, int size, int page, String soryBy, String direction,
            User user);

    List<Contact> getByUserId(String userId);

    Page<Contact> getByUser(User user, int page, int size, String sortField, String sortDirection);
}
