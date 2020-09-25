package com.ecom.webpay.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultTransactionMessage {

    private String buyOrder;
    private Long idTransaction;
    private Date transactionDate;
    private String responseCode;
    private String paymentModuleCode;

}
