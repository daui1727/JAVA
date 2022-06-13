/*
���� ������ : union, union all, minus, intersect
*/

select employee_id, first_name, department_id 
from EMPLOYEES where department_id <= 160
union -- ����
select employee_id, first_name, department_id 
from EMPLOYEES where department_id >= 140;

select employee_id, first_name, department_id 
from EMPLOYEES where department_id <= 100
minus -- 100���� ���� �� �߿��� 50���� ū ������ �� ������ ����
select employee_id, first_name, department_id 
from EMPLOYEES where department_id >= 50;

select employee_id, first_name, department_id 
from EMPLOYEES where department_id <= 100
intersect  -- 100���� ���� �� �߿��� 50���� ū ����
select employee_id, first_name, department_id 
from EMPLOYEES where department_id >= 50;

-- jobs ���̺��� job_title �������� �����Ͽ� ������ȸ.
select * from jobs order by JOB_TITLE;

-- countries ���̺��� country_name ���� ������������ �����Ͽ� ��ȸ
select * from countries order by COUNTRY_NAME desc;

-- employees ���̺��� salary�� 10000���� 12000 ������ ���� ��ȸ
select * from EMPLOYEES where salary >= 10000 and salary <= 12000;
select * from EMPLOYEES where salary BETWEEN 10000 AND 12000;

-- employees ���̺��� job_id�� 'IT_PROG'�� 'ST_MAN'�� ���� ��ȸ
select * from EMPLOYEES where job_id = 'IT_PROG' or job_id = 'ST_MAN';
select * from EMPLOYEES where job_id in('IT_PROG','ST_MAN');

-- employees ���̺��� manager_id�� NULL�� ���� ��ȸ
select * from EMPLOYEES where manager_id is NULL;

-- departments ���̺��� manager_id�� NULL�� �ƴ� �μ� ��ȸ
select * from DEPARTMENTS where manager_id is not NULL;

--  employees ���̺��� job_id�� 'AD'�� �����ϴ� ���� ��ȸ
select * from EMPLOYEES where JOB_ID like 'AD%';

-- employees ���̺��� first_name���� 'ni'�� �����ϴ� ���� ��ȸ
select * from EMPLOYEES where FIRST_NAME like '%ni%';

----------------------------------------------------------------------------
-- ����Ŭ �Լ� ��Ʈ

select first_name, lower(first_name), upper(first_name), initcap(first_name)
from employees;

select job_id, substr(job_id,1,2) as str1, substr(job_id,4) as str2
from EMPLOYEES;  -- ������ ����

select job_id, replace(job_id, 'MGR', 'MANAGER') from EMPLOYEES;
select job_id, replace(job_id, 'PROG', 'PROGRAMMER') from EMPLOYEES;

select first_name, last_name, concat(first_name, concat(' ', last_name)) 
as fullname from EMPLOYEES;  -- �� �� ���ڿ� ����

select first_name, LENGTH(first_name) from EMPLOYEES;

select first_name, instr(first_name, 'a') from EMPLOYEES; -- a�� ���°�� �ִ°�

select LPAD(first_name, 10, '*'), RPAD(first_name, 10, '*') from employees;

select job_id, ltrim(job_id, 'A'), rtrim(job_id, 'T') from EMPLOYEES;

select length(trim(' �浿   ')), length(trim(' ���  �� �� ��' )) from dual;

-- jobs ���̺��� job_title�� �ҹ��ڿ� �빮�ڷ� ��ȯ�� job_title�� ��ȸ.
select  job_title, lower(job_title), upper(job_title) from jobs;

-- employees ���̺��� first_name ù 1 ���ڿ� last_name ��ȸ
select substr(first_name,1,1) as name, last_name from EMPLOYEES;

-- employees ���̺��� job_id�� 'REP'�� �κ��� 'REPRESENTATIVE'�� �ٲ㼭 ��ȸ
select job_id, replace(job_id, 'REP', 'REPRESENTATIVE') from employees;

-- employees ���̺��� first_name ù 1���ڿ� last_name�� �߰��� ������ �ΰ� �ϳ��� �����Ͽ� ��ȸ
select substr(first_name,1,1), last_name, 
concat(substr(first_name,1,1), concat(' ', last_name))
from employees;

-- employees ���̺��� first_name�� last_name�� ���̸� ���ļ� ��ȸ
select length(concat(first_name, last_name)) as length
from employees;

-- employees ���̺��� job_id�� job_id�� 'A' ���� ��ġ ��ȸ
select job_id, instr(job_id, 'A') from employees;

-- locations ���̺��� city�� 15�ڸ� ���ڿ��� �ٲٰ�, �� ������ '.'���� ǥ���Ͽ� ��ȸ
select LPAD(city, 15, '.'), RPAD(city, 15, '.') from locations;

-- locations ���̺��� city�� ���ʺ��� 'S' ���ڸ� ���� �Ͱ� �����ʺ��� 'e'���ڸ� ���� ����� ��ȸ
select city, LTRIM(city, 'S'), RTRIM(city, 'e') from locations;

------------------------------------------------------------------------------
--     ���� �ø�       ���� ����        �ݿø�             ����           ������     �ŵ�����     ������
select ceil(12.345), floor(12.345), round(62.345,-2), trunc(12.345,1), mod(12,5), power(3,3), sqrt(9)
from dual;
--      ��� 1       0     ���� -1
select sign(10), sign(0), sign(-5) from dual;

select sysdate, sysdate+1, sysdate+100 from dual;

select sysdate, MONTHS_BETWEEN(sysdate, hire_date)
from EMPLOYEES where EMPLOYEE_ID = 100;

select hire_date, add_months(hire_date, 2), add_months(hire_date, -2)
from EMPLOYEES;

/*
to_char : ���ڳ� ��¥�� ���� �����ͷ� ����
to_number : ���ڸ� ���ڷ� ����
to_date : ���� �����͸� ��¥ �����ͷ� ����
*/                      
--                     ���� ���� �б�
select to_char(sysdate, 'CC AD Q') from dual;

select to_char(sysdate, 'yyyy/mm/dd') from dual;
select to_char(sysdate, 'yyyy/mm/d') from dual;
select to_char(sysdate, 'yyyy/mon/ddd') from dual;
select sysdate from dual;

select salary, to_char(salary, '$0999999') from EMPLOYEES;
select salary, to_char(salary, '9,999,999') from EMPLOYEES;

