


select * from LOCATIONS where city like 'South%';
select * from LOCATIONS where STREET_ADDRESS like '%St';
select * from LOCATIONS where city like 'South____';

/*
Like ������ >> ���ڿ� �Ӽ����� �κ������� ��ġ�ϴ� �����͸� ����� �� ����Ѵ�.
%  >>  0�� �̻��� ����(������ ����� ������ ��� ����)
_  >>  1���� ����

Like 'data%'   >>   data�� �����ϴ� ���ڿ�
Like '%data'   >>   data�� ������ ���ڿ�
Like '%data%'  >>   data�� ���Ե� ���ڿ�
Like 'data____'  >>  data�� �����ϴ� 8�� ���ڿ�. _ 4��
Like '____data'  >>  data�� ������ 8�� ���ڿ�
*/


select * from EMPLOYEES where COMMISSION_PCT is null;
select * from EMPLOYEES where COMMISSION_PCT is not null;

-- in ������
select * from EMPLOYEES WHERE FIRST_NAME in('Steven', 'John', 'Peter', 'Payam');
select * from COUNTRIES where COUNTRY_ID in('US', 'IL', 'SG');
select * from COUNTRIES where COUNTRY_ID NOT in('US', 'IL', 'SG');

-- between  --> �� ���� ������ �ش��ϴ� �����͸� ����� �� ���Ǵ� Ȯ�� ������
select * from EMPLOYEES where EMPLOYEE_ID BETWEEN 120 and 130;

-- employees ���̺��� job_id�� 'IT_PROG' �̸鼭 salary�� 5000 �ʰ��� ���� ��ȸ.
select * from EMPLOYEES where JOB_ID = 'IT_PROG' and salary > 5000;

-- jobs ���̺��� �ּ� ������ 4000 �̻��̰� �ִ� ������ 10000 ������ ���� ��ȸ.
select * from jobs where min_salary >= 4000 and max_salary <= 10000;

-- jobs ���̺��� �ּ� ������ 8000 �ʰ��� ���� ��ȸ
select * from jobs where min_salary > 8000 order by min_salary desc;

-- employees ���̺��� first_name�� 'David'�� ���� ��ȸ.
select * from employees where first_name = 'David';

-- 100�� 130�� ���� ��ҵ�
select * from EMPLOYEES where not EMPLOYEE_ID = 100 and not EMPLOYEE_ID = 130;


---------------------------------------------------------------
-- ������ ���� �ֱ�~
select FIRST_name, last_name , salary from EMPLOYEES;
select FIRST_name, last_name , salary+10000 from EMPLOYEES;
select FIRST_name, last_name , salary-10000 from EMPLOYEES;
select FIRST_name, last_name , salary*1.1 from EMPLOYEES;

select * from tab;

select department_id as id , department_name as name from departments;

-- || �÷��̳� ���ڿ��� ����
select department_id || department_name name from departments;

select 'department_id' || department_name name from departments;

select 'department_id' || department_name as �μ��� from departments;

-- countries ���̺��� �÷��� country_id�� ���� ID, country_name�� ���������� ��ȸ
select country_id as ����ID , country_name as ������ from countries;

-- countries ���̺��� region_id�� �ߺ� �����ϰ� ��ȸ.
select DISTINCT region_id from countries;

select * from countries;

-- jobs ���̺��� job_title, min_salary, max_salary �÷��� 
-- �ּҿ����� �ִ뿬���� 10% �λ�� ���·� ��ȸ.

select job_title, min_salary*1.1, max_salary*1.1 from jobs;

select * from EMPLOYEES;
select * from employees where EMPLOYEE_ID = 110;
select * from EMPLOYEES where EMPLOYEE_ID <> 110;
select * from EMPLOYEES where EMPLOYEE_ID < 110;  -- 109���� ��Ÿ����..?
select * from EMPLOYEES where EMPLOYEE_ID >= 120 and EMPLOYEE_ID <= 130;
select * from EMPLOYEES where MANAGER_ID = 100 or MANAGER_ID = 120;
-- manager_id�� 100�̰ų� 120�� ��Ҹ�.
select * from EMPLOYEES where last_name = 'Weiss' or last_name = 'Russell';
select * from EMPLOYEES where not DEPARTMENT_ID = 50; -- 50�� �ƴ� ��ҵ�

select count(*) from EMPLOYEES where NOT DEPARTMENT_ID = 50;





/*
������
��� ������(+,-,*,/)
�� ������(= <> != >= <= > <)
�� ������(and, or, not)
���� ������(union, union all, minus, intersect)
SQL ������(between in, like, is null)

���� �Ӹ� �ƴ϶� ���ڳ� ��¥ ���� ���ϴ� �͵� �����ϴ�.
ex) 'A' < 'C'
    '2020-10-10' < '2022-05-17'
    

*/


