package com.ninhngoctuan.day10_ontap_jdbc.dao;

import com.ninhngoctuan.day10_ontap_jdbc.entity.EMPLOYEEEntity;
import com.ninhngoctuan.day10_ontap_jdbc.entity.SALARY_GRADE;

import java.math.BigDecimal;
import java.util.List;

public interface SALARY_GRADEDAO {
    List<SALARY_GRADE> getAll();
    SALARY_GRADE getSALARY_GRADEByid( Integer id);
    Boolean insertSALARY_GRADE(SALARY_GRADE salaryGrade);
    Boolean updateSALARY_GRADE(SALARY_GRADE salaryGrade);
    Boolean deleteSALARY_GRADEByid(Integer id );
}
