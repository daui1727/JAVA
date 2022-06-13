/*
countries ���̺�� locations ���̺��� locations�� country_id�� ��������
�ܺ� �����Ͽ� country_id, country_name, city�� ��ȸ.
*/
select * from locations;
desc locations;

select c.country_id, c.country_name, l.city
from countries c, locations l
where c.COUNTRY_ID = l.COUNTRY_ID(+);

/*
employees ���̺�� departments ���̺��� departments ���̺��� department_id��
�������� �ܺ������Ͽ�  employee_id, first_name, last_name, department_name��
employee_id �� �������� �����Ͽ� ��ȸ.
*/
select * from departments;

select e.employee_id, e.first_name, e.last_name, d.department_name
from employees e, departments d
where e.DEPARTMENT_ID = d.DEPARTMENT_ID(+);

/*
employees ���̺��� manager_id�� employee_id�� �������� ��ü ������ �ڿ� ������
first_name�� last_name�� �����ϰ� �������� first_name�� last_name�� �����Ͽ�
employee_id�� �������� �����Ͽ� ��ȸ.
*/
select * from employees;

select E.FIRST_NAME || ' ' || E.LAST_NAME as employee,
       M.FIRST_NAME || ' ' || M.LAST_NAME as manager
from employees E, employees M
where E.EMPLOYEE_ID = M.MANAGER_ID
order by E.EMPLOYEE_ID;


/*
���� ����
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









