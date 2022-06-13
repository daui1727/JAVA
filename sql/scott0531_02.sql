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
--315p 열 구조만 가져오는

create table empdept_ddl
    as select E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM,
              D.DEPTNO, D.DNAME, D.LOC
    from emp E, dept D
    where 1 <> 1;
    
select * from empdept_ddl;

--- alter

create table emp_alter
    as select * from emp;
    
select * from emp_rename;  -- 이름 바꿈
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

TRUNCATE table emp_rename;  -- 롤백해도 데이터 다 날라감~
ROLLBACK;


--          delete              truncate            drop의 차이
-- 처리 속도   느림                빠름                  빠름
-- commit     직접                자동                  자동
-- 롤백 여부   commit 이전 가능     불가                 불가
-- 삭제 정도   데이터만             테이블을 creat상태로   테이블까지 완전히 제거


/*
    cascade
    
    오라클에서 cascade란

    두 테이블을 연결해서
    
    PK를 가지고 있는 쪽의 값을 삭제하면
    
    FK로 연결된 값이 동시에 삭제되게 하는 옵션이다
*/







