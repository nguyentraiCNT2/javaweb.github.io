package com.example.day09.devmaster.edu.vn.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Basic(optional = false)
    @Column(name = "MaSP")
    private String MaSP;
    @Column(name = "TenSanPham")
    private String TenSanPham;
    @Column(name = "AnhSanPham")
    private String AnhSanPham;
    @Column(name = "SoLuong")
    private Integer SoLuong;
    @Column(name = "DonGia")
    private Double DonGia;
    @Column(name = "TrangThai")
    private Boolean TrangThai;


    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public String getAnhSanPham() {
        return AnhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        AnhSanPham = anhSanPham;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer soLuong) {
        SoLuong = soLuong;
    }

    public Double getDonGia() {
        return DonGia;
    }

    public void setDonGia(Double donGia) {
        DonGia = donGia;
    }

    public Boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        TrangThai = trangThai;
    }
}
