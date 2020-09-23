package com.ecom.webpay.dalc.repositories;

import com.ecom.webpay.dalc.entities.InitTransactionOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInitTransactionOutputRepository extends JpaRepository<InitTransactionOutput, Long> {
}
