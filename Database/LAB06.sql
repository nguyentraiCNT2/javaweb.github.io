CREATE DATABASE Lab04JspServletJDBC
go
use Lab04JspServletJDBC
go
CREATE TABLE USER_ACCOUNT(
USER_NAME VARCHAR(30) NOT NULL,
GENDER VARCHAR(1) NOT NULL,
PASSWORD VARCHAR(30) NOT NULL,
PRIMARY KEY (USER_NAME) 
);
GO 
CREATE TABLE PRODUCT(
CODE VARCHAR(20) NOT NULL,
NAME NVARCHAR(118) NOT NULL,
PRICE FLOAT NOT NULL,
PRIMARY KEY (CODE)
)
GO
CREATE TABLE CUSTOMER(
CusID INT IDENTITY(1,1)  NOT NULL PRIMARY KEY,
CusUser varchar(25) not null,
CusPass varchar(32) not null,
CusName Nvarchar(50) not null, 
CusPhone varchar(12) null UNIQUE,
CusAdd nvarchar(255) null,
CusEmail varchar(50) null,
CusFacebook nvarchar(150)null,
CusSkyber nvarchar(150) null,
CusStatus tinyint not null
)
GO
-- INSERT DATA ---------------------------------------
INSERT INTO USER_ACCOUNT (USER_NAME, GENDER, PASSWORD) VALUES ('tom', 'M', 'tom001');
INSERT INTO USER_ACCOUNT (USER_NAME, GENDER, PASSWORD) VALUES ('jerry', 'M', 'jerry001');
INSERT INTO PRODUCT (CODE, NAME, PRICE) VALUES ('P001', 'java Core ', 100);
INSERT INTO PRODUCT (CODE, NAME, PRICE) VALUES ('P002', 'C# Core', 90);
