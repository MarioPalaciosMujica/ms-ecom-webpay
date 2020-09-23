package com.ecom.webpay.services;

import com.ecom.webpay.dalc.entities.LogError;
import com.ecom.webpay.dalc.repositories.ILogErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LogErrorService {

    @Autowired private ILogErrorRepository logErrorRepository;

    public LogError save(@NotNull LogError entity){
        entity.setIdLogError(null);
        entity.setCreated(new Date());
        entity = logErrorRepository.save(entity);
        return entity;
    }

    public LogError findById(@NotNull Long id){
        Optional<LogError> entity = logErrorRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<LogError> findAll(){
        return logErrorRepository.findAll();
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            logErrorRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
