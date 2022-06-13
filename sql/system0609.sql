-- ȸ�� ���� ���̺� ����
create table member_tbl_02(
    custno number(6) not null,
    custname varchar2(20),
    phone varchar2(13),
    address varchar2(60),
    joindate date,
    grade char(1),
    city char(2),
    PRIMARY KEY (custno)
);

desc MEMBER_TBL_02;

-- ���� �� CRUD ���� �ο�
grant insert, update, delete, select on member_tbl_02 to system;

-- ȸ�� ���̺� ���� ������ �߰�
create sequence member_seq
increment by 1
start with 100001
minvalue 100001
nocycle
cache 10;

drop SEQUENCE member_seq;

-- ������ ���� �߰�
grant alter, select on member_seq to system;

-- Ŀ��
commit;

-- ȸ�� ���� �߰�
insert into MEMBER_TBL_02(custno, custname, phone, address, joindate, grade, city)
values(100001, '���ູ', '010-1111-2222', '���� ���빮�� �ְ�1��', '20151202', 'A', '01');

insert into MEMBER_TBL_02(custno, custname, phone, address, joindate, grade, city)
values(100002, '���ູ', '010-1111-3333', '���� ���빮�� �ְ�2��', '20151206', 'B', '01');

insert into MEMBER_TBL_02(custno, custname, phone, address, joindate, grade, city)
values(100003, '�����', '010-1111-4444', '�︪�� �︪�� ����1��', '20151001', 'B', '30');

insert into MEMBER_TBL_02(custno, custname, phone, address, joindate, grade, city)
values(100004, '�ֻ��', '010-1111-5555', '�︪�� �︪�� ����2��', '20151113', 'A', '30');

insert into MEMBER_TBL_02(custno, custname, phone, address, joindate, grade, city)
values(100005, '����ȭ', '010-1111-6666', '���ֵ� ���ֽ� �ܳ�����', '20151225', 'B', '60');

insert into MEMBER_TBL_02(custno, custname, phone, address, joindate, grade, city)
values(100006, '������', '010-1111-7777', '���ֵ� ���ֽ� ��������', '20151211', 'C', '60');


-- ȸ�� ���� ���� ���� ���̺� �ۼ�
create table money_tbl_02(
    custno number(6) not null,
    safenol number(8) not null,
    pcost number(8),
    amount number(4),
    price number(8),
    pcode varchar2(4),
    sdate date,
    PRIMARY KEY (custno, safenol)
);

desc MONEY_TBL_02;

-- CRUD ���� �ο�
grant insert, update, delete, select on money_tbl_02 to system; 

-- Ŀ��
commit;

-- ���� ���� �߰� 
insert into MONEY_TBL_02(custno, safenol, pcost, amount, price, pcode, sdate)
values(100001, 20160001, 500, 5, 2500, 'A001', '20160101');

insert into MONEY_TBL_02(custno, safenol, pcost, amount, price, pcode, sdate)
values(100001, 20160002, 1000, 4, 4000, 'A002', '20160101');

insert into MONEY_TBL_02(custno, safenol, pcost, amount, price, pcode, sdate)
values(100001, 20160003, 500, 3, 1500, 'A008', '20160101');

insert into MONEY_TBL_02(custno, safenol, pcost, amount, price, pcode, sdate)
values(100002, 20160004, 2000, 1, 2000, 'A004', '20160102');

insert into MONEY_TBL_02(custno, safenol, pcost, amount, price, pcode, sdate)
values(100002, 20160005, 500, 1, 500, 'A001', '20160103');

insert into MONEY_TBL_02(custno, safenol, pcost, amount, price, pcode, sdate)
values(100003, 20160006, 1500, 2, 3000, 'A003', '20160103');

insert into MONEY_TBL_02(custno, safenol, pcost, amount, price, pcode, sdate)
values(100004, 20160007, 500, 2, 1000, 'A001', '20160104');

insert into MONEY_TBL_02(custno, safenol, pcost, amount, price, pcode, sdate)
values(100004, 20160008, 300, 1, 300, 'A005', '20160104');

insert into MONEY_TBL_02(custno, safenol, pcost, amount, price, pcode, sdate)
values(100004, 20160009, 600, 1, 600, 'A006', '20160104');

insert into MONEY_TBL_02(custno, safenol, pcost, amount, price, pcode, sdate)
values(100004, 20160010, 3000, 1, 3000, 'A007', '20160106');

drop table member_tbl_02;
drop table money_tbl_02;

select * from MEMBER_TBL_02;
select * from MONEY_TBL_02;

select m2.custno, m1.custname, m1.grade, sum(m2.price)
from MEMBER_TBL_02 m1, MONEY_TBL_02 m2
where m1.CUSTNO = m2.CUSTNO
group by m2.CUSTNO, m1.custname, m1.grade
order by 4 desc;


