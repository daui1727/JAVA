/*
�����Լ� : count, sum, avg, max, min, --group by having(����)
*/

select * from EMPLOYEES;
select count(first_name) ,count(*) from EMPLOYEES;

select sum(salary), avg(salary) from EMPLOYEES;

select max(salary), min(salary) from EMPLOYEES;

select STDDEV(salary), VARIANCE(salary) from EMPLOYEES; -- ǥ������..?

/*
group by ���� ����
1. ���̺��� where���ǽĿ� �´� ������ ���� ����
2. ������ �� �������� ���� ������ ������ �׷�ȭ
3. ������ ������ �׷�ȭ�� ���� ��� ���
*/
-- job_id ���� salary�� �հ� ����� ���� ��.
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

-- �ִ밪�� 7000 �̻��� �͸�
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

-- employees ���̺��� salary�� 8000�̻��� ������ ���� ��ȸ
select count(*)
from employees
where salary > 8000;

-- employees ���̺��� hire_date�� 2007�� 1�� 1�� ������ ������ ���� ��ȸ
select count(*) 
from employees
where hire_date > '20070101';

-- jobs ���̺��� max_salary ���� �հ�� ����� ��ȸ
select sum(max_salary), avg(max_salary)
from jobs;

-- employees ���̺��� job_id�� 'IT_PROG'�� ������ salary �հ�� ����� ��ȸ
select sum(salary), avg(SALARY)
from employees
where JOB_ID = 'IT_PROG';

-- employees ���̺��� hire_date ���� 2004�� 1�� 1�Ϻ��� 2006�� 12�� 31��
-- ������ �����͸� job_id �������� �׷�ȭ�� �ڿ� job_id�� salary �ּڰ��� �ִ밪�� ��ȸ.
select job_id, max(salary), min(salary)
from employees
where hire_date between '20040101' and '20061231'
group by job_id;

-- employees ���̺��� department_id�� 50�� 80�� �����͸�
-- department_id�� job_id �������� �׷�ȭ�� �ڿ� department_id��
-- job_id, salary �հ�, �ּڰ�, �ִ밪�� job_id �������� �����Ͽ� ��ȸ.
select department_id, job_id, sum(salary), min(salary), max(salary)
from employees
where department_id in(50,80)
group by department_id, job_id
order by job_id;

/*
employees ���̺��� department_id�� job_id �������� �׷�ȭ�� �ڿ�
salary ��հ��� 12000 �̻��� �����͸� department_id�� job_id, salary �ּڰ�,
�ִ밪, ����� department_id �������� �����Ͽ� ��ȸ.
*/
select department_id, job_id, min(salary), max(salary), avg(salary)
from employees
group by department_id, job_id
having avg(salary) >= 12000
order by department_id;

-------------------------------

-- nvl() : null ���� Ư���� ������ ġȯ�ض�.
select department_name, nvl(manager_id, 100)
from departments;

select nvl(state_province, 'None')
from locations
order by state_province;

-- nvl2 : null���� �ִ� ���� ���� ��츦 �����Ͽ� Ư�������� ġȯ����
select department_name, nvl2(manager_id, '������','��')
from departments;

-- decode() : �����Ͱ� ���ǰ��� ��ġ�ϸ� ġȯ ���� ����ϰ� ��ġ���� ������ �⺻ �� ���.
select min_salary, decode(min_salary, 2500, min_salary*1.1, min_salary+1000)
from jobs;
/* decode(m_s, 10, m_s*1.1, m_s) min_salary�� 10�̸� 10���� ���ϰ� �ƴϸ� 4��° �����Է�*/

select min_salary,   -- Ư�� ������ ����� �����λ�
    case
        when min_salary < 4000 then min_salary*1.2
        when min_salary between 4000 and 6000 then min_salary*1.1
        else min_salary
    end as �ּұ޿�
from jobs;

select first_name, salary,   -- ����
    rank() over(order by salary desc) as rank,
    dense_rank() over(order by salary desc) as dense_rank,  -- ���� ��ƴ����.
    row_number() over(order by salary desc) as row_rank -- ���� ���� ����.
from EMPLOYEES;

 
 