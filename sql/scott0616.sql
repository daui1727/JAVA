create table employees(
    id varchar2(10) not null,
    pass varchar2(10) not null,
    name varchar2(24),
    lev char(1) default 'A',    -- A : ���, B : �Ϲ�ȸ��
    enter DATE DEFAULT SYSDATE,  -- �����
    gender char(1) DEFAULT '1',   -- 1 : ����, 2 : ����
    phone varchar2(30),
    PRIMARY KEY (id)
);

create SEQUENCE employees_seq start with 1 INCREMENT by 1;

insert into EMPLOYEES(id, pass, name, lev, gender, phone)
values('pinksung', '3333', '������', 'A', '2', '010-2222-2222');
insert into EMPLOYEES(id, pass, name, lev, gender, phone)
values('subin', '1234', '������', 'B', '1', '010-3333-2222');
insert into EMPLOYEES(id, pass, name, lev, gender, phone)
values('admin', '1111', '���', 'A', '1', '010-4444-3333');


select * from employees order by rownum;
SELECT * FROM(SELECT * FROM EMPLOYEES ORDER BY rownum desc);
commit;




