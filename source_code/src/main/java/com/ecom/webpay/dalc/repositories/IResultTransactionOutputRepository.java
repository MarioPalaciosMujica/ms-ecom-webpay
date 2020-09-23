package com.ecom.webpay.dalc.repositories;

import com.ecom.webpay.dalc.entities.ResultTransactionOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultTransactionOutputRepository extends JpaRepository<ResultTransactionOutput, Long> {
}
