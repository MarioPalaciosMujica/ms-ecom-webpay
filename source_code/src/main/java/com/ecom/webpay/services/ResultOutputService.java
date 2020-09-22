package com.ecom.webpay.services;

import com.ecom.webpay.dalc.entities.DetailOutput;
import com.ecom.webpay.dalc.entities.ResultOutput;
import com.ecom.webpay.dalc.repositories.IResultOutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ResultOutputService {

    @Autowired private IResultOutputRepository resultOutputRepository;

    public ResultOutput save(@NotNull ResultOutput entity){
        entity.setIdResultOutput(null);
        entity.setCreated(new Date());
        for (DetailOutput detailOutput : entity.getDetailsOutput()){
            detailOutput.setIdDetailOutput(null);
            detailOutput.setResultOutput(entity);
        }
        entity = resultOutputRepository.save(entity);
        return entity;
    }

    public ResultOutput findById(@NotNull Long id){
        Optional<ResultOutput> entity = resultOutputRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<ResultOutput> findAll(){
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
