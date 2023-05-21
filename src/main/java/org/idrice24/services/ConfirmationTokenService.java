package org.idrice24.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.idrice24.entities.ConfirmationToken;
import org.idrice24.repositories.ConfirmationTokenRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTakenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTakenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token){
        return confirmationTakenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token){
        return confirmationTakenRepository.updateConfirmedAt(
            token, LocalDateTime.now()
        );
    }
}
