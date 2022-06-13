/*전체 사원 중 ALLEN과 같은 직책인 사원들의 사원 정보, 부서 정보를 다음과 같이 ~ 262P*/
desc emp;

select E.job, E.empno, E.ENAME, E.SAL, E.DEPTNO, D.DNAME
from emp E, dept D
where E.deptno = D.DEPTNO and job = (
    select job
    from emp
    where ename = 'ALLEN'
);

------

select E.empno, E.ename, D.DNAME, E.hiredate, D.loc, E.sal, G.grade
from emp E, dept D, salgrade G
where E.DEPTNO = D.DEPTNO and 
    E.SAL BETWEEN G.losal and G.HISAL and
    E.SAL > (
        select avg(sal)
        from emp
    )
    order by e.sal desc, e.empno;
    
--------------
-- distinct 중복 제거
select E.EMPNO, E.ENAME, E.JOB, D.DEPTNO, D.LOC
from emp E, dept D
where e.deptno = D.DEPTNO and D.DEPTNO = 10
and job not in (
        select DISTINCT job
        from emp
        where deptno = 30
);


-----------
-- 단일행
select E.empno, E.ename, E.sal, S.GRADE
from emp E, salgrade S
where E.SAL BETWEEN s.losal and s.hisal
and sal > (
    select MAX(sal)
    from emp
    where job = 'SALESMAN'
) order by E.EMPNO;


-- 다중행
select E.empno, E.ename, E.sal, S.GRADE
from emp E, salgrade S
where E.SAL BETWEEN s.losal and s.hisal
and sal > all (
    select DISTINCT sal
    from emp
    where job = 'SALESMAN'
) order by E.EMPNO;


------

-- 239p
select deptno, d.dname, e.EMPNO, e.ename, e.sal
from emp e NATURAL join dept D
where e.sal > 2000;

select E.DEPTNO, dname, empNo, ename, sal
from emp E, dept D
where E.deptno = D.DEPTNO and E.SAL > 2000
order by E.DEPTNO;


---
select deptno, dname, 
    trunc(AVG(sal),0) as AVG_SAL, 
    max(sal) as MAX_SAL, 
    min(sal) as MIN_SAL, 
    count(sal) as CNT
from emp e natural join dept D 
group by deptno, dname;

select E.deptno, D.dname, 
    trunc(AVG(sal),0) as AVG_SAL, 
    max(sal) as MAX_SAL, 
    min(sal) as MIN_SAL, 
    count(sal) as CNT
from emp e , dept D
where e.DEPTNO = D.DEPTNO
group by e.DEPTNO, D.DNAME;

desc dept;
desc emp;

-----

select d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
from emp E, dept D
where E.DEPTNO(+) = D.DEPTNO
order by E.DEPTNO, D.DNAME;

select deptno from dept;

------

desc dept;
desc emp;

select d.deptno, D.dname, E.empno, E.ename, E.mgr, E.sal, e.DEPTNO,
        S.losal, S.HISAL, S.GRADE, m.empno as MGR_EMPNO, m.ENAME AS MGR_ENAME
from emp E, dept D, salgrade S, emp m
where E.DEPTNO(+) = D.DEPTNO and E.SAL BETWEEN losal(+) and hisal(+)
and e.mgr = m.empno(+)
order by D.DEPTNO, E.ENAME;












