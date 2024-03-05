package com.ninhngoctuan.day10_ontap_jdbc.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TIMEKEEPER")
public class TIMEKEEPEREntity {
    @Id
    @Basic(optional = false)
    @Column(name = "Timekeeper_Id")
    private String Timekeeper_Id;
    @Column(name = "Date_Time")
    private Date Date_Time;
    @Column(name = "In_Out")
    private String In_Out;
    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private EMPLOYEEEntity EMP_ID;

    public String getTimekeeper_Id() {
        return Timekeeper_Id;
    }

    public void setTimekeeper_Id(String timekeeper_Id) {
        Timekeeper_Id = timekeeper_Id;
    }

    public Date getDate_Time() {
        return Date_Time;
    }

    public void setDate_Time(Date date_Time) {
        Date_Time = date_Time;
    }

    public String getIn_Out() {
        return In_Out;
    }

    public void setIn_Out(String in_Out) {
        In_Out = in_Out;
    }

    public EMPLOYEEEntity getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(EMPLOYEEEntity EMP_ID) {
        this.EMP_ID = EMP_ID;
    }
}
