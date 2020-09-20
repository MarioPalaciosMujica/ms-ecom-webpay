package com.ecom.webpay.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InitTransactionOutputModel {

    @JsonProperty("formAction")
    private String formAction;

    @JsonProperty("tokenWs")
    private String tokenWs;

}
