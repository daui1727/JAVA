use db0416;

create table SEOUL_HOTEL(
	no int,
    name varchar(100),
    score double,
    address varchar(200),
    poster varchar(200),
    images varchar(1000),
    primary key(no)
);

desc seoul_hotel;
select * from seoul_hotel;

create table SEOUL_LOCATION(
	no int,
    name varchar(100),
    address varchar(200),
    poster varchar(200),
    msg varchar(1000),
    primary key(no)
);

desc seoul_location;
select * from seoul_location;

create table SEOUL_NATURE(
	no int,
    name varchar(100),
    address varchar(200),
    poster varchar(200),
    msg varchar(1000),
    primary key(no)
);

desc seoul_nature;
select * from seoul_nature;

create table SEOUL_SHOPPING(
	no int,
    name varchar(100),
    address varchar(200),
    poster varchar(200),
    msg varchar(1000),
    primary key(no)
);

desc seoul_shopping;
select * from seoul_shopping;

drop table seoul_shopping;

commit;

create table jspBoard(
	no int auto_increment,
    name varchar(34) not null,
    subject varchar(1000) not null,
    content text not null,
    pwd varchar(10) not null,
    regdate datetime,
    hit int default 0,
    primary key(no)
);

desc jspBoard;

insert into jspBoard(name, subject, content, pwd, regdate)
value('홍길동', '홍길동전', '재미있는 홍길동', '1234', now());

select * from jspBoard;


create table exBoard(
	no int auto_increment,
    name varchar(34) not null,
    subject varchar(1000) not null,
    content text not null,
    pwd varchar(10) not null,
    regdate datetime,
    hit int default 0,
    primary key(no)
);

insert into exBoard(name, subject, content, pwd, regdate)
value('강아지', '강아지들', '강아지가 많음', '1234', now());

desc exBoard;
select * from exBoard;
select ceil(count(*)/10.0) from exBoard;




