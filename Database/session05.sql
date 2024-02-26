create database Day08javaweb
go 
use Day08javaweb
go 
create table Product(
MaSP varchar(255) not null primary key,
TenSanPham nvarchar(255) not null,
AnhSanPham varchar(255) null,
SoLuong int not null,
DonGia float not null,
TrangThai bit not null
)
drop table Product