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
go
create table EMPLOYEE(
EMP_ID numeric(19,0) not null primary key,
EMP_NAME varchar(50) not null,
EMP_NO varchar(20) not null,
HIRE_DATE datetime not null,
IMAGE image null,
JOB varchar(30) not null,
DEPT_ID int not null,
MNG_ID numeric(19,0) null
)