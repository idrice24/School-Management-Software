package org.idrice24.services;


import org.idrice24.entities.Contact;

public interface ContactService {

    Contact saveContact(Contact contact);

    Iterable<Contact> ShowContact();

    Contact getContactById(long id);

    void deleteContact(Contact contact);
}