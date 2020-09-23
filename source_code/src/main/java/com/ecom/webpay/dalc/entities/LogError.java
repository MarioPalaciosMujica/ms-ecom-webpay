package com.ecom.webpay.dalc.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_log_errors")
public class LogError {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_error", updatable = false, nullable = false, unique = true)
    private Long idLogError;

    @Column(name = "root")
    private String root;

    @Column(name = "msn")
    private String msn;

    @Column(name = "created")
    private Date created;

    public LogError(String root, String msn){
        this.idLogError = null;
        this.root = root;
        this.msn = msn;
        this.created = null;
    }


    public Long getIdLogError() {
        return idLogError;
    }

    public void setIdLogError(Long idLogError) {
        this.idLogError = idLogError;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
