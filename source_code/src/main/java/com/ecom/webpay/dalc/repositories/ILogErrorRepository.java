package com.ecom.webpay.dalc.repositories;

import com.ecom.webpay.dalc.entities.LogError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogErrorRepository extends JpaRepository<LogError, Long> {
}
