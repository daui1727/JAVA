select *
from emp
where sal = any( select max(sal)
                from emp
                group by deptno);

/* �μ� ��ȣ ���� �ִ� �޿� ����ϱ� */         
select max(sal)       
from emp
group by deptno;

select sal from emp;

/* �� �μ��� �ְ� �޿��� ������ �޿��� �޴� ��� ���� ����ϱ� */
select *
from emp
 where sal in(select max(sal)
              from emp
              group by deptno);
              
select *
from emp
where sal = some(select max(sal)
              from emp
              group by deptno);
            
/* 30�� �μ� ������� �ִ� �޿����� ���� �޿��� �޴� ��� ���� ����ϱ� */
select *
from emp
where sal < any(select sal
              from emp
              where deptno=30)
order by sal, empno;
/* ���� 2850���ٸ� �۴ٸ� ��� true�� �ȴ� */

/* �μ� ��ȣ�� 30�� ������� �޿� ����ϱ� */
select sal from emp where deptno = 30;

/* 30�� �μ� ������� �ּ� �޿����� ���� �޿��� �޴� ��� ���� ����ϱ� */
select *
from emp
where sal > any(select sal
              from emp
              where deptno=30)
order by sal, empno;
/* ���� 950���ٸ� ũ�ٸ� ��� true�� �ȴ� */

/* 30�� �μ� ������� �ּ� �޿����� �� ���� �޿��� �޴� ��� ���� ����ϱ� */
select *
from emp
where sal < all(select sal
                from emp
                where deptno=30);
        
----------------------------------------------------------

/* ���߿� ���� ���� */
select *
from emp
where (deptno,sal) in (select deptno, max(sal)
                        from emp
                        group by deptno);



              
