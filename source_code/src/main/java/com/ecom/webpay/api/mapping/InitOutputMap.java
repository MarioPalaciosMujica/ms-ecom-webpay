package com.ecom.webpay.api.mapping;

import com.ecom.webpay.api.models.InitOutputModel;
import com.ecom.webpay.dalc.entities.InitOutput;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitOutputMap {

    public InitOutputModel toModel(InitOutput entity){
        if(entity != null){
            InitOutputModel model = new InitOutputModel();
            model.setFormAction(entity.getFormAction());
            model.setTokenWs(entity.getTokenWs());
            return model;
        }
        else{
            return null;
        }
    }

    public InitOutput toEntity(InitOutputModel model){
        if(model != null){
            InitOutput entity = new InitOutput();
            entity.setFormAction(model.getFormAction());
            entity.setTokenWs(model.getTokenWs());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<InitOutputModel> toModelList(List<InitOutput> listEntity){
        List<InitOutputModel> modelList = new ArrayList<>();
        for (InitOutput entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<InitOutput> toEntityList(List<InitOutputModel> listModel){
        List<InitOutput> entityList = new ArrayList<>();
        for (InitOutputModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
