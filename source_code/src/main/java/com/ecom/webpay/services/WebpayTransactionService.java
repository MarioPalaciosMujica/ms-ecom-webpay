package com.ecom.webpay.services;

import cl.transbank.webpay.Webpay;
import cl.transbank.webpay.WebpayNormal;
import cl.transbank.webpay.configuration.Configuration;
import com.ecom.webpay.dalc.entities.InitTransactionOutput;
import com.transbank.webpay.wswebpay.service.WsInitTransactionOutput;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WebpayTransactionService {

//    public Webpay generateWebpayPlusNormalTransaction(String commerceCode, boolean isEnvironmentProduction){
//        Configuration configuration = new Configuration();
//        configuration.setCommerceCode(commerceCode);
//        configuration.setPrivateKey("BEGIN RSA PRIVATE KEY");
//        configuration.setPublicCert("BEGIN CERTIFICATE");
//        if(isEnvironmentProduction){
//            configuration.setEnvironment(Webpay.Environment.PRODUCCION);
//        }
//        else {
//            configuration.setEnvironment(Webpay.Environment.INTEGRACION);
//        }
//        Webpay webpay = new Webpay(configuration);
//        return webpay;
//    }

    public InitTransactionOutput getInitTransactionOutputIntegration(){
        double amount = 1000;
        String sessionId = "mi-id-de-sesion";
        String buyOrder = String.valueOf(Math.abs(new Random().nextLong()));
        String returnUrl = "https://callback/resultado/de/transaccion";
        String finalUrl = "https://callback/final/post/comprobante/webpay";

        try{
            WebpayNormal transaction = getWpPlusNormal(getConfigurationIntegration());
            WsInitTransactionOutput initResult = transaction.initTransaction(amount, sessionId, buyOrder, returnUrl, finalUrl);
            return new InitTransactionOutput(initResult.getUrl(), initResult.getToken());
        }
        catch (Exception ex){
            System.out.println("getInitTransactionOutputTest()");
            System.out.println(ex.toString());
            return null;
        }
    }

    private Configuration getConfigurationIntegration(){
        return Configuration.forTestingWebpayPlusNormal();
    }

    private WebpayNormal getWpPlusNormal(Configuration wpConfig) throws Exception{
        return new Webpay(wpConfig).getNormalTransaction();
    }

}
