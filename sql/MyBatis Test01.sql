create table board(
    id number(5) primary key,
    name varchar(20),
    phone varchar2(20),
    address varchar2(50)
);

select * from board;

insert into board values(3, 'ȫ�浿', '010-1111-2222', '����� ������');

commit;