create table emp_ddl(
    empno number(4),
    ename varchar2(10),
    job varchar2(9),
    mgr number(4),
    hiredate date,
    sal number(7,2),
    comm number(7,2),
    deptno number(2)
);

desc emp_ddl;
select * from emp_ddl;

create table dept_ddl as select * from dept;
select * from dept_ddl;

create table emp_ddl_30
    as select * from emp
    where deptno = 30;
    
select * from emp_ddl_30;

-----
--315p �� ������ ��������

create table empdept_ddl
    as select E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM,
              D.DEPTNO, D.DNAME, D.LOC
    from emp E, dept D
    where 1 <> 1;
    
select * from empdept_ddl;

--- alter

create table emp_alter
    as select * from emp;
    
select * from emp_rename;  -- �̸� �ٲ�
select * from emp_alter;

alter table emp_alter
    add hp varchar2(20);
    
alter table emp_alter
    rename column hp to tel;
    
alter table emp_alter
    MODIFY empno number(5);
    
alter table emp_alter
    drop column tel;
    
rename emp_alter to emp_rename;

delete from emp_rename;
ROLLBACK;

TRUNCATE table emp_rename;  -- �ѹ��ص� ������ �� ����~
ROLLBACK;


--          delete              truncate            drop�� ����
-- ó�� �ӵ�   ����                ����                  ����
-- commit     ����                �ڵ�                  �ڵ�
-- �ѹ� ����   commit ���� ����     �Ұ�                 �Ұ�
-- ���� ����   �����͸�             ���̺��� creat���·�   ���̺���� ������ ����


/*
    cascade
    
    ����Ŭ���� cascade��

    �� ���̺��� �����ؼ�
    
    PK�� ������ �ִ� ���� ���� �����ϸ�
    
    FK�� ����� ���� ���ÿ� �����ǰ� �ϴ� �ɼ��̴�
*/







