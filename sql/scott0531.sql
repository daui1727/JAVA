create table member(
    name varchar2(10) not null,
    userid varchar2(10),
    pwd varchar2(10) not null,
    email varchar2(20),
    phone char(13),
    admin number(1) default 0, -- 0 : �����, 1 : ������
    PRIMARY KEY(userid)
);

alter table member MODIFY(name varchar2(20));

desc member;

insert into member(name, userid, pwd, email, phone, admin)
values('�̼ҹ�','somi','1234','gmd@naver.com','010-2362-5157',0);

insert into member(name, userid, pwd, email, phone, admin)
values('�ϻ��','sang12','1234','ha12@naver.com','010-222-3333',1);

insert into member(name, userid, pwd, email, phone, admin)
values('������','light','1234','youn1004@naver.com','010-555-4444',0);

select * from member;

insert into member(name, userid, pwd)
values('ȫ�浿','hong','1234');

commit;

update member set phone = '010-777-4321'
where userid='free';









