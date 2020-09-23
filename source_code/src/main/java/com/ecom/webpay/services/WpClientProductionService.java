package com.ecom.webpay.services;

import cl.transbank.webpay.Webpay;
import cl.transbank.webpay.WebpayNormal;
import cl.transbank.webpay.configuration.Configuration;
import com.ecom.webpay.config.AppConfig;
import com.ecom.webpay.dalc.entities.*;
import com.ecom.webpay.tools.DateFormat;
import com.transbank.webpay.wswebpay.service.TransactionResultOutput;
import com.transbank.webpay.wswebpay.service.WsInitTransactionOutput;
import com.transbank.webpay.wswebpay.service.WsTransactionDetailOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashSet;

@Service
public class WpClientProductionService {

    @Autowired private ResultTransactionOutputService resultTransactionOutputService;
    @Autowired private InitTransactionOutputService initTransactionOutputService;
    @Autowired private AppConfig appConfig;
    @Autowired private DateFormat dateFormat;
    @Autowired private LogErrorService logErrorService;

    public InitTransactionOutput getInitTransaction(BuyOrder buyOrder){
        try{
            WebpayNormal transaction = getWpPlusNormal(getConfiguration());
            WsInitTransactionOutput initResult = transaction.initTransaction(
                    buyOrder.getPriceAmount().doubleValue(),
                    buyOrder.getIdSession(),
                    buyOrder.getIdBuyOrder(),
                    appConfig.getWpReturnUrl(),
                    appConfig.getWpFinalUrl()
            );

            InitTransactionOutput initTransactionOutput = new InitTransactionOutput(initResult.getUrl(), initResult.getToken());
            initTransactionOutput = initTransactionOutputService.save(initTransactionOutput);
            return initTransactionOutput;
        }
        catch (Exception ex){
            logErrorService.save(new LogError("WpClientProductionService.getInitTransaction()", ex.toString()));
            return null;
        }
    }

    public ResultTransactionOutput getTransactionResult(@NotNull String tokenWs){
        try{
            WebpayNormal transaction = getWpPlusNormal(getConfiguration());
            TransactionResultOutput result = transaction.getTransactionResult(tokenWs);
            ResultTransactionOutput resultTransactionOutput = this.getWebpayResult(result);
            return resultTransactionOutputService.save(resultTransactionOutput);
        }
        catch (Exception ex){
            logErrorService.save(new LogError("WpClientProductionService.getTransactionResult()", ex.toString()));
            return null;
        }
    }

    private Configuration getConfiguration(){
        Configuration configuration = new Configuration();
        configuration.setCommerceCode(appConfig.getWpPlusComCode());
        configuration.setPrivateKey(appConfig.getWpPrivateKey());
        configuration.setPublicCert(appConfig.getWpPublicCert());
        configuration.setEnvironment(Webpay.Environment.PRODUCCION);
        return configuration;
    }

    private WebpayNormal getWpPlusNormal(Configuration wpConfig) throws Exception{
        return new Webpay(wpConfig).getNormalTransaction();
    }

    private ResultTransactionOutput getWebpayResult(TransactionResultOutput result){
        ResultTransactionOutput resultTransactionOutput = new ResultTransactionOutput();
        resultTransactionOutput.setBuyOrder(result.getBuyOrder());
        resultTransactionOutput.setSessionId(result.getSessionId());
        resultTransactionOutput.setAccountingDate(result.getAccountingDate());
        resultTransactionOutput.setTransactionDate(dateFormat.xmlGregorianToString(result.getTransactionDate()));
        resultTransactionOutput.setVci(result.getVCI());
        resultTransactionOutput.setUrlRedirection(result.getUrlRedirection());
        resultTransactionOutput.setCardDetail(
                new CardDetail(
                        null,
                        result.getCardDetail().getCardNumber(),
                        result.getCardDetail().getCardExpirationDate(),
                        null
                )
        );

        resultTransactionOutput.setDetailsOutput(new HashSet<>());
        for (WsTransactionDetailOutput detailOutput : result.getDetailOutput()){
            DetailOutput newDetail = new DetailOutput();
            newDetail.setAuthorizationCode(detailOutput.getAuthorizationCode());
            newDetail.setPaymentTypeCode(detailOutput.getPaymentTypeCode());
            newDetail.setResponseCode(detailOutput.getResponseCode());
            newDetail.setAmount(detailOutput.getAmount());
            newDetail.setSharesNumber(detailOutput.getSharesNumber());
            newDetail.setCommerceCode(detailOutput.getCommerceCode());
            newDetail.setBuyOrder(detailOutput.getBuyOrder());
            resultTransactionOutput.getDetailsOutput().add(newDetail);
        }
        return resultTransactionOutput;
    }
}
