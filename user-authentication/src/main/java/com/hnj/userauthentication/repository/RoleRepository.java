package com.hnj.userauthentication.repository;

import java.util.Optional;

import com.hnj.userauthentication.model.Role;
import com.hnj.userauthentication.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}