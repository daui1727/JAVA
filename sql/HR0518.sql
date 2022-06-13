/*
집합 연산자 : union, union all, minus, intersect
*/

select employee_id, first_name, department_id 
from EMPLOYEES where department_id <= 160
union -- 더함
select employee_id, first_name, department_id 
from EMPLOYEES where department_id >= 140;

select employee_id, first_name, department_id 
from EMPLOYEES where department_id <= 100
minus -- 100보다 작은 값 중에서 50보다 큰 값들을 뺀 나머지 값들
select employee_id, first_name, department_id 
from EMPLOYEES where department_id >= 50;

select employee_id, first_name, department_id 
from EMPLOYEES where department_id <= 100
intersect  -- 100보다 작은 값 중에서 50보다 큰 값들
select employee_id, first_name, department_id 
from EMPLOYEES where department_id >= 50;

-- jobs 테이블에서 job_title 기준으로 정렬하여 직업조회.
select * from jobs order by JOB_TITLE;

-- countries 테이블에서 country_name 기준 내림차순으로 정렬하여 조회
select * from countries order by COUNTRY_NAME desc;

-- employees 테이블에서 salary가 10000에서 12000 사이인 직원 조회
select * from EMPLOYEES where salary >= 10000 and salary <= 12000;
select * from EMPLOYEES where salary BETWEEN 10000 AND 12000;

-- employees 테이블에서 job_id가 'IT_PROG'와 'ST_MAN'인 직원 조회
select * from EMPLOYEES where job_id = 'IT_PROG' or job_id = 'ST_MAN';
select * from EMPLOYEES where job_id in('IT_PROG','ST_MAN');

-- employees 테이블에서 manager_id가 NULL인 직원 조회
select * from EMPLOYEES where manager_id is NULL;

-- departments 테이블에서 manager_id가 NULL이 아닌 부서 조회
select * from DEPARTMENTS where manager_id is not NULL;

--  employees 테이블에서 job_id가 'AD'로 시작하는 직원 조회
select * from EMPLOYEES where JOB_ID like 'AD%';

-- employees 테이블의 first_name에서 'ni'를 포함하는 직원 조회
select * from EMPLOYEES where FIRST_NAME like '%ni%';

----------------------------------------------------------------------------
-- 오라클 함수 파트

select first_name, lower(first_name), upper(first_name), initcap(first_name)
from employees;

select job_id, substr(job_id,1,2) as str1, substr(job_id,4) as str2
from EMPLOYEES;  -- 나오는 글자

select job_id, replace(job_id, 'MGR', 'MANAGER') from EMPLOYEES;
select job_id, replace(job_id, 'PROG', 'PROGRAMMER') from EMPLOYEES;

select first_name, last_name, concat(first_name, concat(' ', last_name)) 
as fullname from EMPLOYEES;  -- 두 개 문자열 결합

select first_name, LENGTH(first_name) from EMPLOYEES;

select first_name, instr(first_name, 'a') from EMPLOYEES; -- a가 몇번째에 있는가

select LPAD(first_name, 10, '*'), RPAD(first_name, 10, '*') from employees;

select job_id, ltrim(job_id, 'A'), rtrim(job_id, 'T') from EMPLOYEES;

select length(trim(' 길동   ')), length(trim(' 어사  박 문 수' )) from dual;

-- jobs 테이블에서 job_title과 소문자와 대문자로 변환한 job_title을 조회.
select  job_title, lower(job_title), upper(job_title) from jobs;

-- employees 테이블에서 first_name 첫 1 문자와 last_name 조회
select substr(first_name,1,1) as name, last_name from EMPLOYEES;

-- employees 테이블에서 job_id가 'REP'인 부분을 'REPRESENTATIVE'로 바꿔서 조회
select job_id, replace(job_id, 'REP', 'REPRESENTATIVE') from employees;

-- employees 테이블에서 first_name 첫 1문자와 last_name을 중간에 공백을 두고 하나로 결합하여 조회
select substr(first_name,1,1), last_name, 
concat(substr(first_name,1,1), concat(' ', last_name))
from employees;

-- employees 테이블에서 first_name과 last_name의 길이를 합쳐서 조회
select length(concat(first_name, last_name)) as length
from employees;

-- employees 테이블에서 job_id와 job_id에 'A' 문자 위치 조회
select job_id, instr(job_id, 'A') from employees;

-- locations 테이블의 city를 15자리 문자열로 바꾸고, 빈 공간을 '.'으로 표현하여 조회
select LPAD(city, 15, '.'), RPAD(city, 15, '.') from locations;

-- locations 테이블에서 city의 왼쪽부터 'S' 문자를 지운 것과 오른쪽부터 'e'문자를 지운 결과를 조회
select city, LTRIM(city, 'S'), RTRIM(city, 'e') from locations;

------------------------------------------------------------------------------
--     정수 올림       정수 내림        반올림             절삭           나머지     거듭제곱     제곱근
select ceil(12.345), floor(12.345), round(62.345,-2), trunc(12.345,1), mod(12,5), power(3,3), sqrt(9)
from dual;
--      양수 1       0     음수 -1
select sign(10), sign(0), sign(-5) from dual;

select sysdate, sysdate+1, sysdate+100 from dual;

select sysdate, MONTHS_BETWEEN(sysdate, hire_date)
from EMPLOYEES where EMPLOYEE_ID = 100;

select hire_date, add_months(hire_date, 2), add_months(hire_date, -2)
from EMPLOYEES;

/*
to_char : 숫자나 날짜를 문자 데이터로 변경
to_number : 문자를 숫자로 변경
to_date : 문자 데이터를 날짜 데이터로 변경
*/                      
--                     세기 서기 분기
select to_char(sysdate, 'CC AD Q') from dual;

select to_char(sysdate, 'yyyy/mm/dd') from dual;
select to_char(sysdate, 'yyyy/mm/d') from dual;
select to_char(sysdate, 'yyyy/mon/ddd') from dual;
select sysdate from dual;

select salary, to_char(salary, '$0999999') from EMPLOYEES;
select salary, to_char(salary, '9,999,999') from EMPLOYEES;

