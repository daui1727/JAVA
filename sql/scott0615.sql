create table board(
    num number(5) PRIMARY KEY,
    pass varchar2(30),
    name varchar2(30),
    email varchar2(30),
    title varchar2(50),
    content varchar2(1000),
    readcount number(4) DEFAULT 0,
    writedate date DEFAULT sysdate
);

create SEQUENCE board_seq start with 1 INCREMENT by 1;

insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, '������', 'pinksung@nate.com', '1234', 'ù�湮', '�ݰ����ϴ�');
insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, 'ȫ�浿', 'one@nate.com', '1234', '���', '������');
insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, '������', 'two@nate.com', '3333', '����', '�����Դϴ�');
insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, '������', 'three@nate.com', '1111', '������', '���������� ���ֽ��ϴ�');

commit;

select * from board;