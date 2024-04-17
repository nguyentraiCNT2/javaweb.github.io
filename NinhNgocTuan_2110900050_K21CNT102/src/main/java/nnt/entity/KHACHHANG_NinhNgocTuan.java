package nnt.entity;

import java.sql.Date;

public class KHACHHANG_NinhNgocTuan {
	private String makh;
	private String hoten;
	private Date ngaysinh;
	private Boolean gioitinh;
	private String anh;
	private Boolean tinhtrang;
	public KHACHHANG_NinhNgocTuan() {
	}
	public KHACHHANG_NinhNgocTuan(String makh, String hoten, Date ngaysinh, Boolean gioitinh, String anh,
			Boolean tinhtrang) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.anh = anh;
		this.tinhtrang = tinhtrang;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public Boolean getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public Boolean getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(Boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	

}
