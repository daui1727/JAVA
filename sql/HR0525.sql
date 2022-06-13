/*
departments ���̺��� manager_id�� null�� �ƴ� department_id��
��ġ�ϴ� employees ���̺��� first_name, last_name, job_id, salary�� ��ȸ
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
locations ���̺��� city�� 'Seattle'�� �������� �ʴ� location_id��
��ġ�ϴ� departments ���̺��� department_id, department_name�� ��ȸ.
*/
select department_id, department_name, location_id
from DEPARTMENTS
where LOCATION_ID not in (
    select LOCATION_ID
    from LOCATIONS
    where city = 'Seattle'
);

/*
regions ���̺��� region_name�� 'Europe'�� region_id�� ��ġ�ϴ�
countries ���̺��� country_id�� ���Ե� locations ���̺��� city,
state_province, street_address�� ��ȸ.
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
countries ���̺�
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





