package com.ecom.webpay.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultTransactionMessageModel {

    @JsonProperty("buyOrder")
    private String buyOrder;

    @JsonProperty("idTransaction")
    private Long idTransaction;

    @JsonProperty("transactionDate")
    private String transactionDate;

    @JsonProperty("responseCode")
    private String responseCode;

    @JsonProperty("paymentModuleCode")
    private String paymentModuleCode;
}
