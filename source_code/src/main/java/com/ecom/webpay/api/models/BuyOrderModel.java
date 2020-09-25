package com.ecom.webpay.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyOrderModel {

    @JsonProperty("priceAmount")
    private BigDecimal priceAmount;

    @JsonProperty("IdSession")
    private String IdSession;

    @JsonProperty("idBuyOrder")
    private String idBuyOrder;
}
