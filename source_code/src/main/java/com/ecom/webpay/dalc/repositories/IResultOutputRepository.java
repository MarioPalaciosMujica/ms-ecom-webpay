package com.ecom.webpay.dalc.repositories;

import com.ecom.webpay.dalc.entities.ResultOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultOutputRepository extends JpaRepository<ResultOutput, Long> {
}
