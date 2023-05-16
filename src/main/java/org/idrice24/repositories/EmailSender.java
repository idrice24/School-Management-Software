package org.idrice24.repositories;

public interface EmailSender {
    void send(String to, String email);
}
