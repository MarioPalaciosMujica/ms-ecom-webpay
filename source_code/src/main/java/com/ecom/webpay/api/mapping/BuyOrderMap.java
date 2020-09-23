package com.ecom.webpay.api.mapping;

import com.ecom.webpay.api.models.BuyOrderModel;
import com.ecom.webpay.dalc.entities.BuyOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuyOrderMap {

    public BuyOrderModel toModel(BuyOrder entity){
        if(entity != null){
            BuyOrderModel model = new BuyOrderModel();
            model.setPriceAmount(entity.getPriceAmount());
            model.setIdSession(entity.getIdSession());
            model.setIdBuyOrder(entity.getIdBuyOrder());
            return model;
        }
        else{
            return null;
        }
    }

    public BuyOrder toEntity(BuyOrderModel model){
        if(model != null){
            BuyOrder entity = new BuyOrder();
            entity.setPriceAmount(model.getPriceAmount());
            entity.setIdSession(model.getIdSession());
            entity.setIdBuyOrder(model.getIdBuyOrder());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<BuyOrderModel> toModelList(List<BuyOrder> listEntity){
        List<BuyOrderModel> modelList = new ArrayList<>();
        for (BuyOrder entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<BuyOrder> toEntityList(List<BuyOrderModel> listModel){
        List<BuyOrder> entityList = new ArrayList<>();
        for (BuyOrderModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
