create database QLPTGiaoThong

use QLPTGiaoThong

create table Account(
	AccountId INT IDENTITY(1,1) PRIMARY KEY,
	Username nvarchar(255),
	Password nvarchar(255),
	DisplayName nvarchar(255),
	Role varchar(255)
);

create table PTGT(
	id INT IDENTITY(1,1) PRIMARY KEY,
	loaiPhuongTien nvarchar(255),
	hangSanXuat nvarchar(255),
	namSanXuat int,
	giaBan float,
	mau nvarchar(255),
	kieuDongCo nvarchar(255),
	soChoNgoi int,
	congSuat int,
	trongTai float
);