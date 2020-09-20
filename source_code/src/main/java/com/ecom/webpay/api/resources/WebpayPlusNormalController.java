package com.ecom.webpay.api.resources;

import com.ecom.webpay.services.WebpayTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WebpayPlusNormal")
public class WebpayPlusNormalController {

    @Autowired private WebpayTransactionService webpayTransactionService;

    @RequestMapping(value = "/initTransactionOutput", method = RequestMethod.GET)
    public void initTransactionOutput(){
        webpayTransactionService.initTransactionOutput();
    }
}
