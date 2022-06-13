create table member(
    name varchar2(10) not null,
    userid varchar2(10),
    pwd varchar2(10) not null,
    email varchar2(20),
    phone char(13),
    admin number(1) default 0, -- 0 : »ç¿ëÀÚ, 1 : °ü¸®ÀÚ
    PRIMARY KEY(userid)
);

alter table member MODIFY(name varchar2(20));

desc member;

insert into member(name, userid, pwd, email, phone, admin)
values('ÀÌ¼Ò¹Ì','somi','1234','gmd@naver.com','010-2362-5157',0);

insert into member(name, userid, pwd, email, phone, admin)
values('ÇÏ»ó¿À','sang12','1234','ha12@naver.com','010-222-3333',1);

insert into member(name, userid, pwd, email, phone, admin)
values('±èÀ±½Â','light','1234','youn1004@naver.com','010-555-4444',0);

select * from member;

insert into member(name, userid, pwd)
values('È«±æµ¿','hong','1234');

commit;

update member set phone = '010-777-4321'
where userid='free';









