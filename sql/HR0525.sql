/*
departments 테이블에서 manager_id가 null이 아닌 department_id와
일치하는 employees 테이블의 first_name, last_name, job_id, salary를 조회
*/
desc employees;

select first_name, last_name, job_id, salary, department_id
from employees
where DEPARTMENT_ID in (
    select DEPARTMENT_ID
    from departments
    where MANAGER_ID is not null
);

/*
locations 테이블에서 city가 'Seattle'를 포함하지 않는 location_id와
일치하는 departments 테이블의 department_id, department_name을 조회.
*/
select department_id, department_name, location_id
from DEPARTMENTS
where LOCATION_ID not in (
    select LOCATION_ID
    from LOCATIONS
    where city = 'Seattle'
);

/*
regions 테이블에서 region_name이 'Europe'인 region_id가 일치하는
countries 테이블에서 country_id가 포함된 locations 테이블의 city,
state_province, street_address를 조회.
*/
select city, state_province, street_address
from locations
where country_id in (
    select country_id
    from countries
    where region_id = (
        select region_id
        from regions
        where region_name = 'Europe'
    )
);



--------------------------------------------

/*
DML(data manipulation language)
select
insert
update
delete
CRUD
*/

desc countries;

select * from countries;
insert into countries
values('KR', 'North Korea', 3);

insert into countries(country_id, country_name, region_id)
values('KP', 'South Korea',3);

insert into countries(country_id, country_name)
values('KM', 'South Korea');

commit;

update countries
set COUNTRY_NAME = 'South Korea'
where COUNTRY_ID = 'KR';

update countries
set COUNTRY_NAME = 'North Korea'
where COUNTRY_ID = 'KP';

select * from countries;

select *
from jobs
where JOB_ID = 'IT_PROG';

update jobs
set MIN_SALARY = 10000, MAX_SALARY = 20000
where JOB_ID = 'IT_PROG';

delete
from COUNTRIES
where COUNTRY_ID = 'KM';

/*
countries 테이블
country_id country_name region_id
AT Austria 1
NO Norway 1
ID Indonesia 3
TR Turkey 4
*/

select * from countries;
insert into countries(country_id, country_name, region_id)
values('AT', 'Austria', 1);

insert into countries(country_id, country_name, region_id)
values('NO', 'Norway', 1);

insert into countries(country_id, country_name, region_id)
values('ID', 'Indonesia', 3);

insert into countries(country_id, country_name, region_id)
values('TR', 'Turkey', 4);





