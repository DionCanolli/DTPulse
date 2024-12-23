package com.dioncanolli.dtpulse_back_end.repository;

import com.dioncanolli.dtpulse_back_end.entity.JWTTokenBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JWTTokenBlacklistRepository extends JpaRepository<JWTTokenBlacklist, Long> {

    JWTTokenBlacklist findByJwtValue(String value);
}
