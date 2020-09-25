package com.ecom.webpay.api.resources;

import com.ecom.webpay.api.mapping.BuyOrderMap;
import com.ecom.webpay.api.mapping.InitTransactionOutputMap;
import com.ecom.webpay.api.mapping.ResultTransactionMessageMap;
import com.ecom.webpay.api.models.BuyOrderModel;
import com.ecom.webpay.api.models.InitTransactionOutputModel;
import com.ecom.webpay.api.models.ResultTransactionMessageModel;
import com.ecom.webpay.config.AppConfig;
import com.ecom.webpay.services.WpClientIntegrationService;
import com.ecom.webpay.services.WpClientProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.constraints.NotNull;

//@RestController
@Controller
@RequestMapping("/WebpayPlusIntegration")
public class WebpayPlusController {

    @Autowired private WpClientIntegrationService wpClientService; // Integration
    //@Autowired private WpClientProductionService wpClientService; // Production

    @Autowired private ResultTransactionMessageMap resultTransactionMessageMap;
    @Autowired private InitTransactionOutputMap initTransactionOutputMap;
    @Autowired private BuyOrderMap buyOrderMap;
    @Autowired private AppConfig appConfig;

    @RequestMapping(value = "/initTransaction", method = RequestMethod.POST)
    @ResponseBody
    public InitTransactionOutputModel initIntegration(@RequestBody @NotNull BuyOrderModel model){
        return initTransactionOutputMap.toModel(wpClientService.getInitTransaction(buyOrderMap.toEntity(model)));
    }

    @RequestMapping(value = "/response", method = RequestMethod.POST)
    public RedirectView response(@RequestParam("token_ws") String tokenWs){
        ResultTransactionMessageModel model = resultTransactionMessageMap.toModel(wpClientService.getTransactionResult(tokenWs));
        return new RedirectView(appConfig.getWpWebResultUrl(), true);
        //return new ModelAndView(appConfig.getWpWebResultUrl(), model);
    }
}
