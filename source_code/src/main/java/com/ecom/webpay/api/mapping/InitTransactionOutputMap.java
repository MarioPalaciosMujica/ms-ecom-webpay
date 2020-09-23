package com.ecom.webpay.api.mapping;

import com.ecom.webpay.api.models.InitTransactionOutputModel;
import com.ecom.webpay.dalc.entities.InitTransactionOutput;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitTransactionOutputMap {

    public InitTransactionOutputModel toModel(InitTransactionOutput entity){
        if(entity != null){
            InitTransactionOutputModel model = new InitTransactionOutputModel();
            model.setFormAction(entity.getFormAction());
            model.setTokenWs(entity.getTokenWs());
            return model;
        }
        else{
            return null;
        }
    }

    public InitTransactionOutput toEntity(InitTransactionOutputModel model){
        if(model != null){
            InitTransactionOutput entity = new InitTransactionOutput();
            entity.setFormAction(model.getFormAction());
            entity.setTokenWs(model.getTokenWs());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<InitTransactionOutputModel> toModelList(List<InitTransactionOutput> listEntity){
        List<InitTransactionOutputModel> modelList = new ArrayList<>();
        for (InitTransactionOutput entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<InitTransactionOutput> toEntityList(List<InitTransactionOutputModel> listModel){
        List<InitTransactionOutput> entityList = new ArrayList<>();
        for (InitTransactionOutputModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
