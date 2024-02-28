package com.example.lab05hibernate01.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "EMPLOYEE")
public class EMPLOYEE {
    @Id
    @Basic(optional = false)
    @Column(name = "EMP_ID")
    private BigDecimal EMP_ID;
    @Column(name = "EMP_NAME")
    private String EMP_NAME;
    @Column(name = "EMP_NO")
    private String EMP_NO;
    @Column(name = "HIRE_DATE")
    private Date HIRE_DATE;
    @Column(name = "IMAGE")
    private String IMAGE;
    @Column(name = "JOB")
    private String JOB;
    @Column(name = "DEPT_ID")
    private Integer DEPT_ID;
    @Column(name = "MNG_ID")
    private BigDecimal MNG_ID;
    @Column(name = "SALARY")
    private Double SALARY;

    public BigDecimal getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(BigDecimal EMP_ID) {
        this.EMP_ID = EMP_ID;
    }

    public String getEMP_NAME() {
        return EMP_NAME;
    }

    public void setEMP_NAME(String EMP_NAME) {
        this.EMP_NAME = EMP_NAME;
    }

    public String getEMP_NO() {
        return EMP_NO;
    }

    public void setEMP_NO(String EMP_NO) {
        this.EMP_NO = EMP_NO;
    }

    public Date getHIRE_DATE() {
        return HIRE_DATE;
    }

    public void setHIRE_DATE(Date HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public Integer getDEPT_ID() {
        return DEPT_ID;
    }

    public void setDEPT_ID(Integer DEPT_ID) {
        this.DEPT_ID = DEPT_ID;
    }

    public BigDecimal getMNG_ID() {
        return MNG_ID;
    }

    public void setMNG_ID(BigDecimal MNG_ID) {
        this.MNG_ID = MNG_ID;
    }

    public Double getSALARY() {
        return SALARY;
    }

    public void setSALARY(Double SALARY) {
        this.SALARY = SALARY;
    }
}
