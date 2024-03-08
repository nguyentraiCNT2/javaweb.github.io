package com.ninhngoctuan.day10_ontap_jdbc;

import com.ninhngoctuan.day10_ontap_jdbc.dao.IMPL.DEPARTMENTDAOIMPL;
import com.ninhngoctuan.day10_ontap_jdbc.entity.DEPARTMENT;

import java.util.List;

public class testmain {
    public static void main(String[] args) {
        List<DEPARTMENT> list = new DEPARTMENTDAOIMPL().getAll();
        for (DEPARTMENT item :list
             ) {
            System.out.println("max"+item.getDEPT_NAME());
        }
    }
}
