package com.idrice24.repositories;

import com.idrice24.entities.Role;
import com.idrice24.repositories.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

}
