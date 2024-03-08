package com.ninhngoctuan.day10_ontap_jdbc.entity;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class DEPARTMENT {
    @Id
    @Basic(optional = false)
    @Column(name = "DEPT_ID")
    private Integer DEPT_ID;
    @Column(name = "DEPT_NAME")
    private String DEPT_NAME;
    @Column(name = "DEPT_NO")
    private String DEPT_NO;
    @Column(name = "LOCARION")
    private String LOCARION;

    public Integer getDEPT_ID() {
        return DEPT_ID;
    }

    public void setDEPT_ID(Integer DEPT_ID) {
        this.DEPT_ID = DEPT_ID;
    }

    public String getDEPT_NAME() {
        return DEPT_NAME;
    }

    public void setDEPT_NAME(String DEPT_NAME) {
        this.DEPT_NAME = DEPT_NAME;
    }

    public String getDEPT_NO() {
        return DEPT_NO;
    }

    public void setDEPT_NO(String DEPT_NO) {
        this.DEPT_NO = DEPT_NO;
    }

    public String getLOCARION() {
        return LOCARION;
    }

    public void setLOCARION(String LOCARION) {
        this.LOCARION = LOCARION;
    }
}
