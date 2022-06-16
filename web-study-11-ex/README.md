WEB-STUDY-11-EX
회원관리

********************************** 환경
1. windows
2. sts tool (Version:3.9.17.RELEASE)
3. oracle 11g
4. jdk11
5. 인코딩 utf-8
6. git
7. jstl.jar
8. objdbc6.jar
9. standard.jar
10. cos.jar(version:cos-22.05.zip)
11. lombok-1.18.24.jar

*********************************** DB

create table employees(
    id varchar2(10) not null,
    pass varchar2(10) not null,
    name varchar2(24),
    lev char(1) default 'A',    -- A : 운영자, B : 일반회원
    enter DATE DEFAULT SYSDATE,  -- 등록일
    gender char(1) DEFAULT '1',   -- 1 : 남자, 2 : 여자
    phone varchar2(30),
    PRIMARY KEY (id)
);

insert into EMPLOYEES(id, pass, name, lev, gender, phone)
values('pinksung', '3333', '성윤정', 'A', '2', '01022222222');
insert into EMPLOYEES(id, pass, name, lev, gender, phone)
values('subin', '1234', '전원지', 'B', '1', '01033332222');
insert into EMPLOYEES(id, pass, name, lev, gender, phone)
values('admin', '1111', '정운영', 'A', '1', '01044443333');

******************************************************************