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
values(BOARD_SEQ.NEXTVAL, '¼ºÀ±Á¤', 'pinksung@nate.com', '1234', 'Ã¹¹æ¹®', '¹İ°©½À´Ï´Ù');
insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, 'È«±æµ¿', 'one@nate.com', '1234', '±è¹ä', '¸ÀÀÖÀ½');
insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, 'Àü¼öºó', 'two@nate.com', '3333', '°íµî¾î', '»ı¼±ÀÔ´Ï´Ù');
insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, 'Àü¿øÁö', 'three@nate.com', '1111', '°¹°ñ¸¶À»', 'µÅÁö»ï°ã»ìÀÌ ¸ÀÀÖ½À´Ï´Ù');

commit;

select * from board;