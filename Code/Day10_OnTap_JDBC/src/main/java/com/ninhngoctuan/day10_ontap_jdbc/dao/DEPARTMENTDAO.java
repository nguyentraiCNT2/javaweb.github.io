package com.ninhngoctuan.day10_ontap_jdbc.dao;

import com.ninhngoctuan.day10_ontap_jdbc.entity.DEPARTMENT;

import java.util.List;

public interface DEPARTMENTDAO {
    List<DEPARTMENT> getAll();
    List<DEPARTMENT> getDEPARTMENTByDEPT_NAME(String DEPT_NAME);
    DEPARTMENT getDEPARTMENTByid(Integer DEPT_ID);
    Boolean insertDEPARTMENT(DEPARTMENT department);
    Boolean updateDEPARTMENT(DEPARTMENT department);
    Boolean deleteDEPARTMENTByid(Integer DEPT_ID );
}
