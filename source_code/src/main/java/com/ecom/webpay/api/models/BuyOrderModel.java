package com.ecom.webpay.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyOrderModel {

    private BigDecimal priceAmount;
    private String IdSession;
    private String idBuyOrder;
}
