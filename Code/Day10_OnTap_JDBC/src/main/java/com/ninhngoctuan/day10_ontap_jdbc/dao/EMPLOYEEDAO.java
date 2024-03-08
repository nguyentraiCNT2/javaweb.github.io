package com.ninhngoctuan.day10_ontap_jdbc.dao;

import com.ninhngoctuan.day10_ontap_jdbc.entity.EMPLOYEEEntity;

import java.math.BigDecimal;
import java.util.List;

public interface EMPLOYEEDAO {
    List<EMPLOYEEEntity> getAll();
    List<EMPLOYEEEntity> getEMPLOYEEbyEMP_NAME(String EMP_NAME);
    EMPLOYEEEntity getEMPLOYEEByid( BigDecimal id);
    Boolean insertEMPLOYEE(EMPLOYEEEntity employee);
    Boolean updateEMPLOYEE(EMPLOYEEEntity employee);
    Boolean deleteEMPLOYEEByid(BigDecimal id );
}
