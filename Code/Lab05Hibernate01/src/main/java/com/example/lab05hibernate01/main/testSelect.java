package com.example.lab05hibernate01.main;

import com.example.lab05hibernate01.dao.IMPL.EmployeeDAOIMPL;
import com.example.lab05hibernate01.dao.IMPL.ProductDAOIMPL;
import com.example.lab05hibernate01.entity.EMPLOYEE;
import com.example.lab05hibernate01.entity.ProductEntity;

import java.util.List;
import java.util.Scanner;

public class testSelect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<EMPLOYEE> list = new EmployeeDAOIMPL().getAllEmployee();
        if (list == null)
            return;
        for (EMPLOYEE item : list){
            System.out.println(" "+item.getEMP_ID()
                    +"|"+item.getEMP_NAME()
                    +"|"+item.getEMP_NO()
                    +"|"+item.getHIRE_DATE()
                    +"|"+item.getIMAGE()
            +"|"+item.getJOB()
            +"|"+item.getDEPT_ID()
            +"|"+item.getSALARY());
        }
        System.out.print("Nhập EMPLOYEE NAME : ");
        String EMP_NAME = sc.next();
        EMPLOYEE employee = new EmployeeDAOIMPL().getEmployeeByEMP_NAME(EMP_NAME);
        System.out.println(" "+employee.getEMP_ID()
                +"|"+employee.getEMP_NAME()
                +"|"+employee.getEMP_NO()
                +"|"+employee.getHIRE_DATE()
                +"|"+employee.getIMAGE()
                +"|"+employee.getJOB()
                +"|"+employee.getDEPT_ID()
                +"|"+employee.getSALARY());
    }
}
