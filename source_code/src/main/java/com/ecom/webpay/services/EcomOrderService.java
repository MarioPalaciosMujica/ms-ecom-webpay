package com.ecom.webpay.services;

import com.ecom.webpay.api.mapping.ResultTransactionMessageMap;
import com.ecom.webpay.api.models.ResultTransactionMessageModel;
import com.ecom.webpay.config.AppConfig;
import com.ecom.webpay.dalc.entities.ResultTransactionMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class EcomOrderService {

    @Autowired private AppConfig appConfig;
    @Autowired private ResultTransactionMessageMap resultTransactionMessageMap;
    @Autowired private LogErrorService logErrorService;

    public void sendResultTransaction(ResultTransactionMessage resultTransactionMessage) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        ResultTransactionMessageModel resultModel = resultTransactionMessageMap.toModel(resultTransactionMessage);

        String json = mapper.writeValueAsString(resultModel);
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(appConfig.getEcomOrderEndpoint());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        restTemplate.exchange(uri, HttpMethod.POST, request, ResultTransactionMessageModel.class);
    }

}
