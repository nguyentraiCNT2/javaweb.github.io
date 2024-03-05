package com.ninhngoctuan.day10_ontap_jdbc.entity;

import javax.persistence.*;

@Entity
@Table(name = "SALARY_GRADE")
public class SALARY_GRADE {
    @Id
    @Basic(optional = false)
    @Column(name = "GREDE")
    private Integer GREDE;
    @Column(name = "HIGH_SALARY")
    private Double HIGH_SALARY;
    @Column(name = "LOW_SALARY")
    private Double LOW_SALARY;

    public Integer getGREDE() {
        return GREDE;
    }

    public void setGREDE(Integer GREDE) {
        this.GREDE = GREDE;
    }

    public Double getHIGH_SALARY() {
        return HIGH_SALARY;
    }

    public void setHIGH_SALARY(Double HIGH_SALARY) {
        this.HIGH_SALARY = HIGH_SALARY;
    }

    public Double getLOW_SALARY() {
        return LOW_SALARY;
    }

    public void setLOW_SALARY(Double LOW_SALARY) {
        this.LOW_SALARY = LOW_SALARY;
    }
}
