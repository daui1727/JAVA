select *
from emp
where sal = any( select max(sal)
                from emp
                group by deptno);

/* 부서 번호 별로 최대 급여 출력하기 */         
select max(sal)       
from emp
group by deptno;

select sal from emp;

/* 각 부서별 최고 급여와 동일한 급여를 받는 사원 정보 출력하기 */
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
            
/* 30번 부서 사원들의 최대 급여보다 적은 급여를 받는 사원 정보 출력하기 */
select *
from emp
where sal < any(select sal
              from emp
              where deptno=30)
order by sal, empno;
/* 값이 2850보다만 작다면 모두 true가 된다 */

/* 부서 번호가 30인 사원들의 급여 출력하기 */
select sal from emp where deptno = 30;

/* 30번 부서 사원들의 최소 급여보다 많은 급여를 받는 사원 정보 출력하기 */
select *
from emp
where sal > any(select sal
              from emp
              where deptno=30)
order by sal, empno;
/* 값이 950보다만 크다면 모두 true가 된다 */

/* 30번 부서 사원들의 최소 급여보다 더 적은 급여를 받는 사원 정보 출력하기 */
select *
from emp
where sal < all(select sal
                from emp
                where deptno=30);
        
----------------------------------------------------------

/* 다중열 서브 쿼리 */
select *
from emp
where (deptno,sal) in (select deptno, max(sal)
                        from emp
                        group by deptno);



              
