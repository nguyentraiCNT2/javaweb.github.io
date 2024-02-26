create database Lab05_Hibernate
go
use Lab05_Hibernate
go
create table Product(
MaSP nvarchar(5) not null primary key,
TenSanPham nvarchar(500) null,
AnhSanPham nvarchar(500) null,
SoLuong int null,
DonGia float null,
TrangThai bit null
)