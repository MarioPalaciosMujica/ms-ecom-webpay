package com.ecom.webpay.services;

import com.ecom.webpay.dalc.entities.DetailOutput;
import com.ecom.webpay.dalc.entities.ResultTransactionOutput;
import com.ecom.webpay.dalc.repositories.IResultTransactionOutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ResultTransactionOutputService {

    @Autowired private IResultTransactionOutputRepository resultOutputRepository;

    public ResultTransactionOutput save(@NotNull ResultTransactionOutput entity){
        entity.setIdResultTransactionOutput(null);
        entity.setCreated(new Date());
        for (DetailOutput detailOutput : entity.getDetailsOutput()){
            detailOutput.setIdDetailOutput(null);
            detailOutput.setResultTransactionOutput(entity);
        }
        entity = resultOutputRepository.save(entity);
        return entity;
    }

    public ResultTransactionOutput findById(@NotNull Long id){
        Optional<ResultTransactionOutput> entity = resultOutputRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<ResultTransactionOutput> findAll(){
        return resultOutputRepository.findAll();
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            resultOutputRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
