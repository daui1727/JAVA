CREATE TABLE CHAP10HW_EMP AS SELECT * FROM EMP;
CREATE TABLE CHAP10HW_DEPT AS SELECT * FROM DEPT;
CREATE TABLE CHAP10HW_SALGRADE AS SELECT * FROM SALGRADE;

/* 1 */
select * from CHAP10HW_DEPT;

insert into CHAP10HW_DEPT(DEPTNO, DNAME, LOC)
values(50, 'ORACLE', 'BUSAN');
insert into CHAP10HW_DEPT(DEPTNO, DNAME, LOC)
values(60, 'SQL', 'ILSAN');
insert into CHAP10HW_DEPT(DEPTNO, DNAME, LOC)
values(70, 'SELECT', 'INCHEON');
insert into CHAP10HW_DEPT(DEPTNO, DNAME, LOC)
values(80, 'DML', 'BUNDANG');

/* 2 */
select * from CHAP10HW_EMP;

insert all
    into CHAP10HW_EMP values(7201,'TEST_USER1','MANAGER',7788,'2016-01-02',1800,NULL,50)
    into CHAP10HW_EMP values(7202,'TEST_USER2','MANAGER',7788,'2016-01-02',1800,NULL,50)
    into CHAP10HW_EMP values(7203,'TEST_USER3','MANAGER',7788,'2016-01-02',1800,NULL,50)
    into CHAP10HW_EMP values(7204,'TEST_USER4','MANAGER',7788,'2016-01-02',1800,300,50)
    into CHAP10HW_EMP values(7205,'TEST_USER5','MANAGER',7788,'2016-01-02',1800,NULL,50)
    into CHAP10HW_EMP values(7206,'TEST_USER6','MANAGER',7788,'2016-01-02',1800,NULL,50)
    into CHAP10HW_EMP values(7207,'TEST_USER7','MANAGER',7788,'2016-01-02',1800,NULL,50)
    into CHAP10HW_EMP values(7208,'TEST_USER8','MANAGER',7788,'2016-01-02',1800,NULL,50)
SELECT * FROM dual;

---------------------------------

select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal, s.grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno
and e.sal between s.losal and s.hisal
and e.sal > (
    select avg(sal)
    from emp
)
order by e.sal desc, e.empno;


