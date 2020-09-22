package com.ecom.webpay.services;

import com.ecom.webpay.dalc.entities.InitOutput;
import com.ecom.webpay.dalc.repositories.IInitOutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InitOutputService {

    @Autowired private IInitOutputRepository initOutputRepository;

    public InitOutput save(@NotNull InitOutput entity){
        entity.setIdInitOutput(null);
        entity.setCreated(new Date());
        initOutputRepository.save(entity);
        return entity;
    }

    public InitOutput findById(@NotNull Long id){
        Optional<InitOutput> entity = initOutputRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<InitOutput> findAll(){
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
