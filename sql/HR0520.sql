select * from EMPLOYEES;
select * from DEPARTMENTS;

/* īƼ�� �� : ��� �࿡ ���ؼ� ���� */
select * from EMPLOYEES, DEPARTMENTS;

/* �������� : �����ϴ� ���̺��� ���� ������ ��ġ�ϴ� �͸� ��ȸ >>> �������� */
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
�ܺ����� : �����ϴ� ���̺��� ���� ������ �������� �ʴ� �൵ ���
          �������� ������ �������� ���ϰ� ������ ���� ����� �� ����Ѵ�.
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

/* countries ���̺�� locations ���̺��� country_id�� �������� �����Ͽ�
country_name, state_province, street_address�� ��ȸ */
select c.country_name, l.state_province, l.street_address
from countries c, locations l
where c.country_id = l.country_id;

/* jobs ���̺�� job_history ���̺��� job_id�� �������� �����Ͽ�
job_id, job_title, start_date, end_date�� ��ȸ */
select * from jobs;

select j.job_id, j.job_title, h.start_date, h.end_date
from jobs j, JOB_HISTORY h
where j.JOB_ID = h.JOB_ID(+);

/* employees ���̺�� departments ���̺��� department_id �������� �����ϰ�,
 employees ���̺�� jobs ���̺��� job_id �������� �����Ͽ� first_name,
 last_name, department_name, job_title�� ��ȸ */
 select * from departments;
 
 select e.first_name, e.last_name, d.department_name, j.job_title
 from employees e, departments d, jobs j
 where e.JOB_ID = j.JOB_ID and e.department_id = d.department_id;
 
 /* countries ���̺�� locations ���̺��� locations�� country_id�� ��������
 �ܺ� �����Ͽ� country_id, country_name, city�� ��ȸ */
 
 select c.country_id, c.country_name, l.city
 from countries c, locations l
 where c.country_id = l.country_id(+);
 


