select * from EMPLOYEES;
select * from DEPARTMENTS;

/* 카티션 곱 : 모든 행에 대해서 조인 */
select * from EMPLOYEES, DEPARTMENTS;

/* 동등조인 : 조인하는 테이블에서 조인 조건이 일치하는 것만 조회 >>> 내부조인 */
select *
from jobs, JOB_HISTORY
where JOBS.JOB_ID = JOB_HISTORY.JOB_ID;

select C.region_id, L.location_id, L.country_id
from COUNTRIES C, LOCATIONS L
where C.COUNTRY_ID = L.country_id;

select *
from EMPLOYEES e, DEPARTMENTS d
where e.DEPARTMENT_ID = d.DEPARTMENT_ID;

select salary from EMPLOYEES;
select * from jobs;

select e.SALARY, j.MIN_SALARY, j.MAX_SALARY 
from EMPLOYEES e, jobs j
where e.salary between j.min_salary and j.MAX_SALARY;

select e.first_name, e.hire_date, j.start_date, j.end_date
from employees e, JOB_HISTORY j
where e.hire_date BETWEEN j.start_date and j.END_DATE;

select count(*)
from EMPLOYEES
where HIRE_DATE BETWEEN '20070101' and '20071231';

/*---------------------------------------------------------*/

/*
외부조인 : 조인하는 테이블에서 조인 조건을 만족하지 않는 행도 출력
          동등조인 조건을 만족하지 못하고 누락된 행을 출력할 때 사용한다.
*/

select *
from jobs j, JOB_HISTORY h
where j.JOB_ID(+) = h.JOB_ID;

select *
from COUNTRIES c, LOCATIONS l
where c.COUNTRY_ID = l.COUNTRY_ID(+);

select a.first_name, a.last_name, b.first_name, b.last_name
from employees a, employees b
where a.manager_id = b.employee_id;

/* countries 테이블과 locations 테이블을 country_id를 기준으로 조인하여
country_name, state_province, street_address를 조회 */
select c.country_name, l.state_province, l.street_address
from countries c, locations l
where c.country_id = l.country_id;

/* jobs 테이블과 job_history 테이블을 job_id를 기준으로 조인하여
job_id, job_title, start_date, end_date를 조회 */
select * from jobs;

select j.job_id, j.job_title, h.start_date, h.end_date
from jobs j, JOB_HISTORY h
where j.JOB_ID = h.JOB_ID(+);

/* employees 테이블과 departments 테이블을 department_id 기준으로 조인하고,
 employees 테이블과 jobs 테이블을 job_id 기준으로 조인하여 first_name,
 last_name, department_name, job_title을 조회 */
 select * from departments;
 
 select e.first_name, e.last_name, d.department_name, j.job_title
 from employees e, departments d, jobs j
 where e.JOB_ID = j.JOB_ID and e.department_id = d.department_id;
 
 /* countries 테이블과 locations 테이블을 locations의 country_id를 기준으로
 외부 조인하여 country_id, country_name, city를 조회 */
 
 select c.country_id, c.country_name, l.city
 from countries c, locations l
 where c.country_id = l.country_id(+);
 


