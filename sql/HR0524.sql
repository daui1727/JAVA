/* ���� �������� */ 

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

/* 100���� �����ϸ� ���~ */
select *
from EMPLOYEES
where EXISTS (
    select *
    from EMPLOYEES
    where EMPLOYEE_ID=100
);

/* any, some : ���������� ���ǽ��� �����ϴ� ���������� ����� �ϳ� �̻��̸� true */
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
departments ���̺��� department_name�� 'IT'��
department_id�� ��ġ�ϴ� employees ���̺��� first_name, last_name, job_id,
salary �� ��ȸ.
*/
select first_name, last_name, job_id, salary
from EMPLOYEES
where department_id = (
    select department_id
    from DEPARTMENTS
    where department_name = 'IT'
);

/*
locations ���̺��� state_province�� 'California'�� location_id��
��ġ�ϴ� departments ���̺��� department_id, department_name�� ��ȸ
*/
select department_id, department_name
from DEPARTMENTS
where location_id = (
    select location_id
    from locations
    where STATE_PROVINCE = 'California'
);

/*
countries ���̺��� region_id�� 3�� country_id�� ���Ե�
locations ���̺��� city, state_province, street_address�� ��ȸ.
*/
select city, state_province, street_address
from locations
where country_id in (
    select country_id
    from countries
    where region_id = 3
);

desc locations;

