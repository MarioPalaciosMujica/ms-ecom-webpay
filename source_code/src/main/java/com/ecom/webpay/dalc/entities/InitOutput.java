package com.ecom.webpay.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tbl_init_outputs")
@NoArgsConstructor
@AllArgsConstructor
public class InitOutput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_init_output", updatable = false, nullable = false, unique = true)
    private Long idInitOutput;

    @Column(name = "form_action")
    @Size(max = 256)
    private String formAction;

    @Column(name = "token_ws")
    @Size(max = 100)
    private String tokenWs;

    @Column(name = "created", nullable = false)
    private Date created;


    public Long getIdInitOutput() {
        return idInitOutput;
    }

    public void setIdInitOutput(Long idInitOutput) {
        this.idInitOutput = idInitOutput;
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
