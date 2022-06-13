/*
집계함수 : count, sum, avg, max, min, --group by having(조건)
*/

select * from EMPLOYEES;
select count(first_name) ,count(*) from EMPLOYEES;

select sum(salary), avg(salary) from EMPLOYEES;

select max(salary), min(salary) from EMPLOYEES;

select STDDEV(salary), VARIANCE(salary) from EMPLOYEES; -- 표준편차..?

/*
group by 동작 순서
1. 테이블에서 where조건식에 맞는 데이터 값만 구분
2. 지정한 열 기준으로 같은 데이터 값으로 그룹화
3. 지정한 열들의 그룹화된 집계 결과 출력
*/
-- job_id 별로 salary의 합계 평균을 구한 것.
select job_id, sum(salary), avg(salary) from EMPLOYEES group by job_id;

select job_id, sum(salary), avg(salary) from EMPLOYEES
where department_id = 50 group by job_id;
 
select department_id, max(salary), min(salary) from EMPLOYEES
group by department_id;

select department_id, max(salary), min(salary) from EMPLOYEES
where hire_date > '20070101' group by department_id;
 
select department_id, salary, HIRE_DATE from EMPLOYEES
where hire_date > '20070101';

select country_id, count(country_id) from locations group by COUNTRY_ID;

select job_id, department_id, sum(salary), avg(salary) from EMPLOYEES
where department_id BETWEEN 50 and 100 group by job_id, DEPARTMENT_ID;
 
select manager_id, department_id, sum(salary), avg(salary) from EMPLOYEES
where DEPARTMENT_ID = 50 GROUP by MANAGER_ID, DEPARTMENT_ID ORDER by MANAGER_ID;

select department_id, manager_id, job_id, max(salary), min(salary)
from EMPLOYEES group by DEPARTMENT_ID, MANAGER_ID, JOB_ID
order by manager_id, DEPARTMENT_ID desc;

select job_id, sum(salary), avg(salary) from EMPLOYEES group by JOB_ID
HAVING avg(salary) >= 10000;

-- 최대값이 7000 이상인 것만
select department_id, min(salary), max(salary) from EMPLOYEES
group by DEPARTMENT_ID
HAVING max(salary) > 7000 order by max(salary);

select country_id, count(country_id) from LOCATIONS group by COUNTRY_ID
HAVING count(country_id)>2;

select job_id, department_id, sum(salary), avg(salary)
from EMPLOYEES 
where DEPARTMENT_ID BETWEEN 51 and 99
group by job_id, department_id
having avg(salary) > 9000
order by avg(salary);

select manager_id, department_id, job_id, sum(salary), avg(salary), max(salary)
from EMPLOYEES
where manager_id in(100,101)
GROUP by manager_id, department_id, job_id
having sum(salary) between 10000 and 40000
order by sum(salary);

-- employees 테이블에서 salary가 8000이상인 직원의 수를 조회
select count(*)
from employees
where salary > 8000;

-- employees 테이블에서 hire_date가 2007년 1월 1일 이후인 직원의 수를 조회
select count(*) 
from employees
where hire_date > '20070101';

-- jobs 테이블에서 max_salary 값의 합계와 평균을 조회
select sum(max_salary), avg(max_salary)
from jobs;

-- employees 테이블에서 job_id가 'IT_PROG'인 직원의 salary 합계와 평균을 조회
select sum(salary), avg(SALARY)
from employees
where JOB_ID = 'IT_PROG';

-- employees 테이블에서 hire_date 값이 2004년 1월 1일부터 2006년 12월 31일
-- 사이의 데이터를 job_id 기준으로 그룹화한 뒤에 job_id와 salary 최솟값과 최대값을 조회.
select job_id, max(salary), min(salary)
from employees
where hire_date between '20040101' and '20061231'
group by job_id;

-- employees 테이블에서 department_id가 50과 80인 데이터를
-- department_id와 job_id 기준으로 그룹화한 뒤에 department_id와
-- job_id, salary 합계, 최솟값, 최대값을 job_id 기준으로 정렬하여 조회.
select department_id, job_id, sum(salary), min(salary), max(salary)
from employees
where department_id in(50,80)
group by department_id, job_id
order by job_id;

/*
employees 테이블에서 department_id와 job_id 기준으로 그룹화한 뒤에
salary 평균값이 12000 이상인 데이터만 department_id와 job_id, salary 최솟값,
최대값, 평균을 department_id 기준으로 정렬하여 조회.
*/
select department_id, job_id, min(salary), max(salary), avg(salary)
from employees
group by department_id, job_id
having avg(salary) >= 12000
order by department_id;

-------------------------------

-- nvl() : null 값을 특정한 값으로 치환해라.
select department_name, nvl(manager_id, 100)
from departments;

select nvl(state_province, 'None')
from locations
order by state_province;

-- nvl2 : null값이 있는 경우와 없는 경우를 구분하여 특정값으로 치환가능
select department_name, nvl2(manager_id, '관리자','무')
from departments;

-- decode() : 데이터가 조건값과 일치하면 치환 값을 출력하고 일치하지 않으면 기본 값 출력.
select min_salary, decode(min_salary, 2500, min_salary*1.1, min_salary+1000)
from jobs;
/* decode(m_s, 10, m_s*1.1, m_s) min_salary가 10이면 10프로 더하고 아니면 4번째 조건입력*/

select min_salary,   -- 특정 범위의 사람들 연봉인상
    case
        when min_salary < 4000 then min_salary*1.2
        when min_salary between 4000 and 6000 then min_salary*1.1
        else min_salary
    end as 최소급여
from jobs;

select first_name, salary,   -- 순위
    rank() over(order by salary desc) as rank,
    dense_rank() over(order by salary desc) as dense_rank,  -- 순위 빈틈없이.
    row_number() over(order by salary desc) as row_rank -- 공통 순위 없음.
from EMPLOYEES;

 
 