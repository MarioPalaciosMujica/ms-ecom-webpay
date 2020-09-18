package com.ecom.webpay.services;

import cl.transbank.webpay.Webpay;
import cl.transbank.webpay.configuration.Configuration;
import org.springframework.stereotype.Service;

@Service
public class WebpayTransactionService {

    public Webpay generateWebpayPlusNormalTransaction(String commerceCode, boolean isEnvironmentProduction){
        Configuration configuration = new Configuration();
        configuration.setCommerceCode(commerceCode);
        configuration.setPrivateKey("BEGIN RSA PRIVATE KEY");
        configuration.setPublicCert("BEGIN CERTIFICATE");
        if(isEnvironmentProduction){
            configuration.setEnvironment(Webpay.Environment.PRODUCCION);
        }
        else {
            configuration.setEnvironment(Webpay.Environment.INTEGRACION);
        }
        Webpay webpay = new Webpay(configuration);
        return webpay;
    }
}
