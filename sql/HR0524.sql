/* 다중 서브쿼리 */ 

select SALARY from EMPLOYEES
where salary in(
    select max(salary)
    from EMPLOYEES
    group by DEPARTMENT_ID
)
order by salary;

select max(salary)
from EMPLOYEES
group by DEPARTMENT_ID;

select SALARY from EMPLOYEES
where salary not in(
    select max(salary)
    from EMPLOYEES
    group by DEPARTMENT_ID
)
order by salary;

/* 100번이 존재하면 출력~ */
select *
from EMPLOYEES
where EXISTS (
    select *
    from EMPLOYEES
    where EMPLOYEE_ID=100
);

/* any, some : 메인쿼리의 조건식을 만족하는 서브쿼리의 결과가 하나 이상이면 true */
select *
from EMPLOYEES
where salary <> any(6000, 10000, 12000);

/*------------------------------*/

select *
from EMPLOYEES
where salary < any(
    select salary
    from EMPLOYEES
    where hire_date > '08/01/01'
);

----------------------------------------

/*
departments 테이블에서 department_name이 'IT'인
department_id와 일치하는 employees 테이블의 first_name, last_name, job_id,
salary 를 조회.
*/
select first_name, last_name, job_id, salary
from EMPLOYEES
where department_id = (
    select department_id
    from DEPARTMENTS
    where department_name = 'IT'
);

/*
locations 테이블에서 state_province이 'California'인 location_id와
일치하는 departments 테이블의 department_id, department_name을 조회
*/
select department_id, department_name
from DEPARTMENTS
where location_id = (
    select location_id
    from locations
    where STATE_PROVINCE = 'California'
);

/*
countries 테이블에서 region_id가 3인 country_id가 포함된
locations 테이블의 city, state_province, street_address를 조회.
*/
select city, state_province, street_address
from locations
where country_id in (
    select country_id
    from countries
    where region_id = 3
);

desc locations;

