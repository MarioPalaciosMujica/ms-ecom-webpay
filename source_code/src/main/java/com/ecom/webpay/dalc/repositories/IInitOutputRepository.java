package com.ecom.webpay.dalc.repositories;

import com.ecom.webpay.dalc.entities.InitOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInitOutputRepository extends JpaRepository<InitOutput, Long> {
}
