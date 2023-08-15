package org.idrice24.repositories;

import java.util.Optional;

import org.idrice24.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(
        "UPDATE AppUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1"
    )
    int enabledAppUser(String email);
}
