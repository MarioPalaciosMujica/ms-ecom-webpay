package com.ecom.webpay.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitTransactionOutput {

    private String formAction;
    private String tokenWs;

}
