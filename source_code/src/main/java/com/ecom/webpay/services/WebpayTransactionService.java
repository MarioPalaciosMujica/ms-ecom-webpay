package com.ecom.webpay.services;

import cl.transbank.webpay.Webpay;
import cl.transbank.webpay.WebpayNormal;
import cl.transbank.webpay.configuration.Configuration;
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

    private WebpayNormal getWpPlusNormal(){
        try{
            Configuration configuration = Configuration.forTestingWebpayPlusNormal();
            WebpayNormal transaction = new Webpay(configuration).getNormalTransaction();
            return transaction;
        }
        catch(Exception ex){
            System.out.println("getWpPlusNormal()");
            System.out.println(ex.toString());
            return null;
        }
    }

    public void initTransactionOutput(){

        double amount = 1000;
        String sessionId = "mi-id-de-sesion";
        String buyOrder = String.valueOf(Math.abs(new Random().nextLong()));
        String returnUrl = "https://callback/resultado/de/transaccion";
        String finalUrl = "https://callback/final/post/comprobante/webpay";

        WebpayNormal transaction = getWpPlusNormal();

        WsInitTransactionOutput initResult =
                transaction.initTransaction(amount, sessionId, buyOrder, returnUrl, finalUrl);

        String formAction = initResult.getUrl();
        String tokenWs = initResult.getToken();

        System.out.println("formAction: " + formAction);
        System.out.println("tokenWs: " + tokenWs);

    }
}
