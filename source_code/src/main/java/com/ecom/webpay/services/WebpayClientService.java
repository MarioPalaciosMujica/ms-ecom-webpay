package com.ecom.webpay.services;

import cl.transbank.webpay.Webpay;
import cl.transbank.webpay.WebpayNormal;
import cl.transbank.webpay.configuration.Configuration;
import com.ecom.webpay.config.AppConfig;
import com.ecom.webpay.dalc.entities.CardDetail;
import com.ecom.webpay.dalc.entities.DetailOutput;
import com.ecom.webpay.dalc.entities.InitOutput;
import com.ecom.webpay.dalc.entities.ResultOutput;
import com.ecom.webpay.tools.DateFormat;
import com.transbank.webpay.wswebpay.service.TransactionResultOutput;
import com.transbank.webpay.wswebpay.service.WsInitTransactionOutput;
import com.transbank.webpay.wswebpay.service.WsTransactionDetailOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Random;

@Service
public class WebpayClientService {

    //TODO: acknowledgeTransaction()

    @Autowired private ResultOutputService resultOutputService;
    @Autowired private InitOutputService initOutputService;
    @Autowired private AppConfig appConfig;
    @Autowired private DateFormat dateFormat;

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

    public InitOutput getInitIntegration(){
        double amount = 1000;
        String sessionId = "mi-id-de-sesion";
        String buyOrder = String.valueOf(Math.abs(new Random().nextLong()));
        String returnUrl = appConfig.getWpReturnUrl();
        String finalUrl = appConfig.getWpFinalUrl();

        try{
            WebpayNormal transaction = getWpPlusNormal(getConfigurationIntegration());
            WsInitTransactionOutput initResult = transaction.initTransaction(amount, sessionId, buyOrder, returnUrl, finalUrl);

            InitOutput initOutput = new InitOutput(null, initResult.getUrl(), initResult.getToken(), null);
            initOutput = initOutputService.save(initOutput);
            return initOutput;
        }
        catch (Exception ex){
            System.out.println("getInitIntegration()");
            System.out.println(ex.toString());
            return null;
        }
    }

    public ResultOutput getTransactionResult(@NotNull String tokenWs){
        try{
            WebpayNormal transaction = getWpPlusNormal(getConfigurationIntegration());
            TransactionResultOutput result = transaction.getTransactionResult(tokenWs);
            ResultOutput resultOutput = this.getWebpayResult(result);
            return resultOutputService.save(resultOutput);
        }
        catch (Exception ex){
            System.out.println("getTransactionResult()");
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

    private ResultOutput getWebpayResult(TransactionResultOutput result){
        ResultOutput resultOutput = new ResultOutput();
        resultOutput.setBuyOrder(result.getBuyOrder());
        resultOutput.setSessionId(result.getSessionId());
        resultOutput.setAccountingDate(result.getAccountingDate());
        resultOutput.setTransactionDate(dateFormat.xmlGregorianToString(result.getTransactionDate()));
        resultOutput.setVci(result.getVCI());
        resultOutput.setUrlRedirection(result.getUrlRedirection());
        resultOutput.setCardDetail(
                new CardDetail(
                        null,
                        result.getCardDetail().getCardNumber(),
                        result.getCardDetail().getCardExpirationDate(),
                        null
                )
        );

        resultOutput.setDetailsOutput(new HashSet<>());
        for (WsTransactionDetailOutput detailOutput : result.getDetailOutput()){
            DetailOutput newDetail = new DetailOutput();
            newDetail.setAuthorizationCode(detailOutput.getAuthorizationCode());
            newDetail.setPaymentTypeCode(detailOutput.getPaymentTypeCode());
            newDetail.setResponseCode(detailOutput.getResponseCode());
            newDetail.setAmount(detailOutput.getAmount());
            newDetail.setSharesNumber(detailOutput.getSharesNumber());
            newDetail.setCommerceCode(detailOutput.getCommerceCode());
            newDetail.setBuyOrder(detailOutput.getBuyOrder());
            resultOutput.getDetailsOutput().add(newDetail);
        }
        return resultOutput;
    }

}
