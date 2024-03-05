package com.ninhngoctuan.day10_ontap_jdbc.dao;

import com.ninhngoctuan.day10_ontap_jdbc.entity.DEPARTMENTEntity;
import com.ninhngoctuan.day10_ontap_jdbc.entity.EMPLOYEEEntity;

import java.util.List;

public interface DEPARTMENTDAO {
    List<DEPARTMENTEntity> getAll();
    List<DEPARTMENTEntity> getDEPARTMENTByDEPT_NAME(String DEPT_NAME);
    DEPARTMENTEntity getDEPARTMENTByid( Integer DEPT_ID);
    Boolean insertDEPARTMENT(DEPARTMENTEntity department);
    Boolean updateDEPARTMENT(DEPARTMENTEntity department);
    Boolean deleteDEPARTMENTByid(Integer DEPT_ID );
}
