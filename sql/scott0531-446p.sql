create table employee(
    name varchar2(20) not null,
    address varchar2(100),
    ssn varchar2(15),
    PRIMARY KEY(name)
);

desc employee;

insert into employee(name, address, ssn)
values('duke', 'seoul', '970224-1039234');

insert into employee(name, address, ssn)
values('pororo', 'pusan', '001222-1038782');

insert into employee(name, address, ssn)
values('candy', 'daejeon', '981221-1829192');

select * from employee;

commit;