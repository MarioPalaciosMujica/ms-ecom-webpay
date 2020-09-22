package com.ecom.webpay.api.resources;

import com.ecom.webpay.api.mapping.InitOutputMap;
import com.ecom.webpay.api.models.InitOutputModel;
import com.ecom.webpay.config.AppConfig;
import com.ecom.webpay.services.WebpayClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/WebpayPlus")
public class WebpayPlusController {

    @Autowired private WebpayClientService webpayClientService;
    @Autowired private InitOutputMap initOutputMap;
    @Autowired private AppConfig appConfig;

    @RequestMapping(value = "/initIntegration", method = RequestMethod.GET)
    public InitOutputModel initIntegration(){
        return initOutputMap.toModel(webpayClientService.getInitIntegration());
    }

    @RequestMapping(value = "/response", method = RequestMethod.POST)
    public RedirectView response(@RequestParam("token_ws") String tokenWs){
        webpayClientService.getTransactionResult(tokenWs);
        return new RedirectView(appConfig.getWpWebResultUrl(), true);
    }
}
