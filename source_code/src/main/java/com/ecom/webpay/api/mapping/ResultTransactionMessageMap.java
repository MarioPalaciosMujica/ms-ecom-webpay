package com.ecom.webpay.api.mapping;

import com.ecom.webpay.api.models.ResultTransactionMessageModel;
import com.ecom.webpay.dalc.entities.ResultTransactionMessage;
import com.ecom.webpay.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResultTransactionMessageMap {

    @Autowired private DateFormat dateFormat;

    public ResultTransactionMessageModel toModel(ResultTransactionMessage entity){
        if(entity != null){
            ResultTransactionMessageModel model = new ResultTransactionMessageModel();
            model.setBuyOrder(entity.getBuyOrder());
            model.setIdTransaction(entity.getIdTransaction());
            model.setTransactionDate(dateFormat.dateToString(entity.getTransactionDate()));
            model.setResponseCode(entity.getResponseCode());
            model.setPaymentModuleCode(entity.getPaymentModuleCode());
            return model;
        }
        else{
            return null;
        }
    }

    public ResultTransactionMessage toEntity(ResultTransactionMessageModel model){
        if(model != null){
            ResultTransactionMessage entity = new ResultTransactionMessage();
            entity.setBuyOrder(model.getBuyOrder());
            entity.setIdTransaction(model.getIdTransaction());
            entity.setTransactionDate(dateFormat.stringToDate(model.getTransactionDate()));
            entity.setResponseCode(model.getResponseCode());
            entity.setPaymentModuleCode(model.getPaymentModuleCode());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<ResultTransactionMessageModel> toModelList(List<ResultTransactionMessage> listEntity){
        List<ResultTransactionMessageModel> modelList = new ArrayList<>();
        for (ResultTransactionMessage entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<ResultTransactionMessage> toEntityList(List<ResultTransactionMessageModel> listModel){
        List<ResultTransactionMessage> entityList = new ArrayList<>();
        for (ResultTransactionMessageModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
