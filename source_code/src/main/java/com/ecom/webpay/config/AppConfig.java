package com.ecom.webpay.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;


@Component
@ConfigurationProperties
@PropertySource("application.properties")
@Data
public class AppConfig {

    @NotEmpty
    @Value("${webpay.return_url}")
    private String wpReturnUrl;

    @NotEmpty
    @Value("${webpay.web.result_url}")
    private String wpWebResultUrl;

    @NotEmpty
    @Value("${webpay.final_url}")
    private String wpFinalUrl;

    @NotEmpty
    @Value("${webpay.rsa_private_key}")
    private String wpPrivateKey;

    @NotEmpty
    @Value("${webpay..certificate}")
    private String wpPublicCert;

    @NotEmpty
    @Value("${webpay.plus.commerce_code}")
    private String wpPlusComCode;

    @NotEmpty
    @Value("${webpay.plus.differed_capture.commerce_code}")
    private String wpPlusDiffComCode;

    @NotEmpty
    @Value("${webpay.mall.store_one.commerce_code}")
    private String wpMallStoreComCode1;

    @NotEmpty
    @Value("${webpay.mall.store_two.commerce_code}")
    private String wpMallStoreComCode2;

    @NotEmpty
    @Value("${webpay.mall.store_three.commerce_code}")
    private String wpMallStoreComCode3;

    @NotEmpty
    @Value("${webpay.oneclick.commerce_code}")
    private String wpOneClickComCode;

    @NotEmpty
    @Value("${webpay.oneclick_mall.store_one.commerce_code}")
    private String wpOneClickMallStoreComCode1;

    @NotEmpty
    @Value("${webpay.oneclick_mall.store_two.commerce_code}")
    private String wpOneClickMallStoreComCode2;

    @NotEmpty
    @Value("${webpay.oneclick_mall.store_three.commerce_code}")
    private String wpOneClickMallStoreComCode3;

}
