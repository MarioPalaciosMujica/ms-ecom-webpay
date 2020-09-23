package com.ecom.webpay.dalc.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tbl_init_transaction_outputs")
@NoArgsConstructor
public class InitTransactionOutput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_init_transaction_output", updatable = false, nullable = false, unique = true)
    private Long idInitTransactionOutput;

    @Column(name = "form_action")
    @Size(max = 256)
    private String formAction;

    @Column(name = "token_ws")
    @Size(max = 100)
    private String tokenWs;

    @Column(name = "created", nullable = false)
    private Date created;

    public InitTransactionOutput(String formAction, String tokenWs){
        this.formAction = formAction;
        this.tokenWs = tokenWs;
    }


    public Long getIdInitTransactionOutput() {
        return idInitTransactionOutput;
    }

    public void setIdInitTransactionOutput(Long idInitTransactionOutput) {
        this.idInitTransactionOutput = idInitTransactionOutput;
    }

    public String getFormAction() {
        return formAction;
    }

    public void setFormAction(String formAction) {
        this.formAction = formAction;
    }

    public String getTokenWs() {
        return tokenWs;
    }

    public void setTokenWs(String tokenWs) {
        this.tokenWs = tokenWs;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
