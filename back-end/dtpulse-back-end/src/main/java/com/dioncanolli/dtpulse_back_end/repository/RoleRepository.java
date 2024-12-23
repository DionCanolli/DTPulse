package com.dioncanolli.dtpulse_back_end.repository;

import com.dioncanolli.dtpulse_back_end.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
