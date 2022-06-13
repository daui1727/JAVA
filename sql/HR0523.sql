/*
countries 테이블과 locations 테이블을 locations의 country_id를 기준으로
외부 조인하여 country_id, country_name, city를 조회.
*/
select * from locations;
desc locations;

select c.country_id, c.country_name, l.city
from countries c, locations l
where c.COUNTRY_ID = l.COUNTRY_ID(+);

/*
employees 테이블과 departments 테이블을 departments 테이블의 department_id를
기준으로 외부조인하여  employee_id, first_name, last_name, department_name을
employee_id 를 기준으로 정렬하여 조회.
*/
select * from departments;

select e.employee_id, e.first_name, e.last_name, d.department_name
from employees e, departments d
where e.DEPARTMENT_ID = d.DEPARTMENT_ID(+);

/*
employees 테이블을 manager_id와 employee_id를 기준으로 자체 조인한 뒤에 직원의
first_name과 last_name을 결합하고 관리자의 first_name과 last_name을 결합하여
employee_id를 기준으로 정렬하여 조회.
*/
select * from employees;

select E.FIRST_NAME || ' ' || E.LAST_NAME as employee,
       M.FIRST_NAME || ' ' || M.LAST_NAME as manager
from employees E, employees M
where E.EMPLOYEE_ID = M.MANAGER_ID
order by E.EMPLOYEE_ID;


/*
서브 쿼리
*/
select * from EMPLOYEES where PHONE_NUMBER = '515.123.4567';

select phone_number
from EMPLOYEES
where EMPLOYEE_ID = 100;

select * from EMPLOYEES
where PHONE_NUMBER = (
    select phone_number
    from EMPLOYEES
    where EMPLOYEE_ID = 100
);

select *
from EMPLOYEES
where hire_date = '03/06/17';

select hire_date
from EMPLOYEES
where email = 'SKING';

select *
from EMPLOYEES
where hire_date = (
    select hire_date
    from EMPLOYEES
    where email = 'SKING'
);

select *
from EMPLOYEES
where hire_date < (
    select hire_date
    from EMPLOYEES
    where email = 'SKING'
);

select first_name, salary
from EMPLOYEES
where salary < (
    select salary
    from EMPLOYEES
    where email = 'SKING'
);

-- hire_date 06/01/03 --> salary
select *
from EMPLOYEES
where salary > (
    select salary
    from employees
    where hire_date = '06/01/03'
);









