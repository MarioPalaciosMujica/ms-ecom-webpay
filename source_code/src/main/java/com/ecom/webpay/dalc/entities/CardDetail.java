package com.ecom.webpay.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_card_details")
@NoArgsConstructor
@AllArgsConstructor
public class CardDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card_detail", updatable = false, nullable = false, unique = true)
    private Long idCardDetail;

    @Column(name = "card_number")
    @Size(max = 16)
    private String cardNumber;

    @Column(name = "card_expiration_date")
    @Size(max = 4)
    private String cardExpirationDate;

    @OneToOne(mappedBy = "cardDetail")
    private ResultTransactionOutput resultTransactionOutput;


    public Long getIdCardDetail() {
        return idCardDetail;
    }

    public void setIdCardDetail(Long idCardDetail) {
        this.idCardDetail = idCardDetail;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public ResultTransactionOutput getResultTransactionOutput() {
        return resultTransactionOutput;
    }

    public void setResultTransactionOutput(ResultTransactionOutput resultTransactionOutput) {
        this.resultTransactionOutput = resultTransactionOutput;
    }
}
