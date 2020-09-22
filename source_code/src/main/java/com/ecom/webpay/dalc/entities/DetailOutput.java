package com.ecom.webpay.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_detail_outputs")
@NoArgsConstructor
@AllArgsConstructor
public class DetailOutput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail_output", updatable = false, nullable = false, unique = true)
    private Long idDetailOutput;

    @Column(name = "authorization_code")
    @Size(max = 6)
    private String authorizationCode;

    @Column(name = "payment_type_code")
    @Size(max = 5)
    private String paymentTypeCode;

    @Column(name = "response_code")
    //@Size(max = 5)
    private Integer responseCode;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "shares_number")
    private Integer sharesNumber;

    @Column(name = "commerce_code")
    @Size(max = 12)
    private String commerceCode;

    @Column(name = "buy_order")
    @Size(max = 26)
    private String buyOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_result_output")
    private ResultOutput resultOutput;


    public Long getIdDetailOutput() {
        return idDetailOutput;
    }

    public void setIdDetailOutput(Long idDetailOutput) {
        this.idDetailOutput = idDetailOutput;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getSharesNumber() {
        return sharesNumber;
    }

    public void setSharesNumber(Integer sharesNumber) {
        this.sharesNumber = sharesNumber;
    }

    public String getCommerceCode() {
        return commerceCode;
    }

    public void setCommerceCode(String commerceCode) {
        this.commerceCode = commerceCode;
    }

    public String getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(String buyOrder) {
        this.buyOrder = buyOrder;
    }

    public ResultOutput getResultOutput() {
        return resultOutput;
    }

    public void setResultOutput(ResultOutput resultOutput) {
        this.resultOutput = resultOutput;
    }
}
