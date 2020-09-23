package com.ecom.webpay.services;

import com.ecom.webpay.dalc.entities.InitTransactionOutput;
import com.ecom.webpay.dalc.repositories.IInitTransactionOutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InitTransactionOutputService {

    @Autowired private IInitTransactionOutputRepository initOutputRepository;

    public InitTransactionOutput save(@NotNull InitTransactionOutput entity){
        entity.setIdInitTransactionOutput(null);
        entity.setCreated(new Date());
        initOutputRepository.save(entity);
        return entity;
    }

    public InitTransactionOutput findById(@NotNull Long id){
        Optional<InitTransactionOutput> entity = initOutputRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<InitTransactionOutput> findAll(){
        return initOutputRepository.findAll();
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            initOutputRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

}
