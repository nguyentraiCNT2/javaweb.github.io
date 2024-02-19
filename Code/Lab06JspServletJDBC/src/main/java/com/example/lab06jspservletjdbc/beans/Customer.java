package com.example.lab06jspservletjdbc.beans;

public class Customer {
    private int CusID;
    private String CusUser;
    private  String CusPass;
    private String CusName;
    private String CusPhone;
    private String CusAdd;
    private String CusEmail;
    private String CusFacebook;
    private String  CusSkyber;
    private Byte CusStatus;

    public Customer() {
    }

    public Customer(int cusID, String cusUser, String cusPass, String cusName, String cusPhone, String cusAdd, String cusEmail, String cusFacebook, String cusSkyber, Byte cusStatus) {
        CusID = cusID;
        CusUser = cusUser;
        CusPass = cusPass;
        CusName = cusName;
        CusPhone = cusPhone;
        CusAdd = cusAdd;
        CusEmail = cusEmail;
        CusFacebook = cusFacebook;
        CusSkyber = cusSkyber;
        CusStatus = cusStatus;
    }

    public int getCusID() {
        return CusID;
    }

    public void setCusID(int cusID) {
        CusID = cusID;
    }

    public String getCusUser() {
        return CusUser;
    }

    public void setCusUser(String cusUser) {
        CusUser = cusUser;
    }

    public String getCusPass() {
        return CusPass;
    }

    public void setCusPass(String cusPass) {
        CusPass = cusPass;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public String getCusPhone() {
        return CusPhone;
    }

    public void setCusPhone(String cusPhone) {
        CusPhone = cusPhone;
    }

    public String getCusAdd() {
        return CusAdd;
    }

    public void setCusAdd(String cusAdd) {
        CusAdd = cusAdd;
    }

    public String getCusEmail() {
        return CusEmail;
    }

    public void setCusEmail(String cusEmail) {
        CusEmail = cusEmail;
    }

    public String getCusFacebook() {
        return CusFacebook;
    }

    public void setCusFacebook(String cusFacebook) {
        CusFacebook = cusFacebook;
    }

    public String getCusSkyber() {
        return CusSkyber;
    }

    public void setCusSkyber(String cusSkyber) {
        CusSkyber = cusSkyber;
    }

    public Byte getCusStatus() {
        return CusStatus;
    }

    public void setCusStatus(Byte cusStatus) {
        CusStatus = cusStatus;
    }
}
