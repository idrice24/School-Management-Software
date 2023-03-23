package org.idrice24.services;


import org.idrice24.entities.Contact;
import org.idrice24.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact saveContact(Contact contact) {

        return contactRepository.save(contact);
        
    }

    @Override
    public Iterable<Contact> ShowContact() {
        return null;
        
    }

    @Override
    public Contact getContactById(long id) {
        
        return contactRepository.findById(id);
    }

    @Override
    public void deleteContact(Contact contact) {
        
        contactRepository.delete(contact);
        
    }

}