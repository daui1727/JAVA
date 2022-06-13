


select * from LOCATIONS where city like 'South%';
select * from LOCATIONS where STREET_ADDRESS like '%St';
select * from LOCATIONS where city like 'South____';

/*
Like 연산자 >> 문자열 속성에서 부분적으로 일치하는 데이터만 출력할 때 사용한다.
%  >>  0개 이상의 문자(문자의 내용과 갯수는 상관 없음)
_  >>  1개의 문자

Like 'data%'   >>   data로 시작하는 문자열
Like '%data'   >>   data로 끝나는 문자열
Like '%data%'  >>   data가 포함된 문자열
Like 'data____'  >>  data로 시작하는 8개 문자열. _ 4개
Like '____data'  >>  data로 끝나는 8개 문자열
*/


select * from EMPLOYEES where COMMISSION_PCT is null;
select * from EMPLOYEES where COMMISSION_PCT is not null;

-- in 연산자
select * from EMPLOYEES WHERE FIRST_NAME in('Steven', 'John', 'Peter', 'Payam');
select * from COUNTRIES where COUNTRY_ID in('US', 'IL', 'SG');
select * from COUNTRIES where COUNTRY_ID NOT in('US', 'IL', 'SG');

-- between  --> 두 값의 범위에 해당하는 데이터만 출력할 때 사용되는 확장 연산자
select * from EMPLOYEES where EMPLOYEE_ID BETWEEN 120 and 130;

-- employees 테이블에서 job_id가 'IT_PROG' 이면서 salary가 5000 초과인 직원 조회.
select * from EMPLOYEES where JOB_ID = 'IT_PROG' and salary > 5000;

-- jobs 테이블에서 최소 월급이 4000 이상이고 최대 월급이 10000 이하인 직업 조회.
select * from jobs where min_salary >= 4000 and max_salary <= 10000;

-- jobs 테이블에서 최소 월급이 8000 초과인 직업 조회
select * from jobs where min_salary > 8000 order by min_salary desc;

-- employees 테이블에서 first_name이 'David'인 직원 조회.
select * from employees where first_name = 'David';

-- 100과 130이 없는 요소들
select * from EMPLOYEES where not EMPLOYEE_ID = 100 and not EMPLOYEE_ID = 130;


---------------------------------------------------------------
-- 직원들 월급 주기~
select FIRST_name, last_name , salary from EMPLOYEES;
select FIRST_name, last_name , salary+10000 from EMPLOYEES;
select FIRST_name, last_name , salary-10000 from EMPLOYEES;
select FIRST_name, last_name , salary*1.1 from EMPLOYEES;

select * from tab;

select department_id as id , department_name as name from departments;

-- || 컬럼이나 문자열을 연결
select department_id || department_name name from departments;

select 'department_id' || department_name name from departments;

select 'department_id' || department_name as 부서명 from departments;

-- countries 테이블에서 컬럼명 country_id를 국가 ID, country_name을 국가명으로 조회
select country_id as 국가ID , country_name as 국가명 from countries;

-- countries 테이블에서 region_id를 중복 제외하고 조회.
select DISTINCT region_id from countries;

select * from countries;

-- jobs 테이블에서 job_title, min_salary, max_salary 컬럼을 
-- 최소연봉과 최대연봉을 10% 인상된 상태로 조회.

select job_title, min_salary*1.1, max_salary*1.1 from jobs;

select * from EMPLOYEES;
select * from employees where EMPLOYEE_ID = 110;
select * from EMPLOYEES where EMPLOYEE_ID <> 110;
select * from EMPLOYEES where EMPLOYEE_ID < 110;  -- 109까지 나타내는..?
select * from EMPLOYEES where EMPLOYEE_ID >= 120 and EMPLOYEE_ID <= 130;
select * from EMPLOYEES where MANAGER_ID = 100 or MANAGER_ID = 120;
-- manager_id가 100이거나 120인 요소만.
select * from EMPLOYEES where last_name = 'Weiss' or last_name = 'Russell';
select * from EMPLOYEES where not DEPARTMENT_ID = 50; -- 50이 아닌 요소들

select count(*) from EMPLOYEES where NOT DEPARTMENT_ID = 50;





/*
연산자
산술 연산자(+,-,*,/)
비교 연산자(= <> != >= <= > <)
논리 연산자(and, or, not)
집합 연산자(union, union all, minus, intersect)
SQL 연산자(between in, like, is null)

숫자 뿐만 아니라 문자나 날짜 값을 비교하는 것도 가능하다.
ex) 'A' < 'C'
    '2020-10-10' < '2022-05-17'
    

*/


