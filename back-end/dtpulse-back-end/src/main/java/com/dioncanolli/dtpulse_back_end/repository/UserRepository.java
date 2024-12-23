package com.dioncanolli.dtpulse_back_end.repository;

import com.dioncanolli.dtpulse_back_end.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    void deleteAllByEmail(String email);
}
