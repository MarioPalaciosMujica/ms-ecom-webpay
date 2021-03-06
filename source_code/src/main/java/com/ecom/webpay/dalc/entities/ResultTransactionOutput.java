package com.ecom.webpay.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_result_transaction_outputs")
@NoArgsConstructor
@AllArgsConstructor
public class ResultTransactionOutput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_result_transaction_output", updatable = false, nullable = false, unique = true)
    private Long idResultTransactionOutput;

    @Column(name = "buy_order")
    @Size(max = 26)
    private String buyOrder;

    @Column(name = "session_id")
    @Size(max = 61)
    private String sessionId;

    @Column(name = "accounting_date")
    @Size(max = 10)
    private String accountingDate;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "vci")
    @Size(max = 10)
    private String Vci;

    @Column(name = "url_redirection")
    @Size(max = 256)
    private String urlRedirection;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_card_detail", referencedColumnName = "id_card_detail")
    private CardDetail cardDetail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resultTransactionOutput", cascade = CascadeType.ALL)
    private Set<DetailOutput> detailsOutput;

    @Column(name = "created", nullable = false)
    private Date created;


    public Long getIdResultTransactionOutput() {
        return idResultTransactionOutput;
    }

    public void setIdResultTransactionOutput(Long idResultTransactionOutput) {
        this.idResultTransactionOutput = idResultTransactionOutput;
    }

    public String getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(String buyOrder) {
        this.buyOrder = buyOrder;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getVci() {
        return Vci;
    }

    public void setVci(String vci) {
        Vci = vci;
    }

    public String getUrlRedirection() {
        return urlRedirection;
    }

    public void setUrlRedirection(String urlRedirection) {
        this.urlRedirection = urlRedirection;
    }

    public CardDetail getCardDetail() {
        return cardDetail;
    }

    public void setCardDetail(CardDetail cardDetail) {
        this.cardDetail = cardDetail;
    }

    public Set<DetailOutput> getDetailsOutput() {
        return detailsOutput;
    }

    public void setDetailsOutput(Set<DetailOutput> detailsOutput) {
        this.detailsOutput = detailsOutput;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
