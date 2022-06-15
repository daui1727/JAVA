create table product(
    code number(5),
    name varchar2(100),
    price number(8),
    pictureurl varchar(50),
    description varchar(1000),
    PRIMARY KEY (code)
);

create SEQUENCE product_seq start with 1 INCREMENT by 1;

insert into product values(product_seq.nextval, '개념을 콕콕 잡아주는 데이터베이스', 27000, 'db.jpg', '데이터베이스에 관한 모든 것을 쉽고 재미있게 정리한 교재...');
insert into product values(product_seq.nextval, '웹표준을 위한 HTML5', 25000, 'html5.jpg', 'HTML5 가이드북. 홈페이지 제작을 위한 필수 선택 HTML 기본 문법...');
insert into product values(product_seq.nextval, 'Dynamic Programming book 시리즈-01 오라클 11g + PL/SQL', 25000, 'oracle.jpg','Dynamic 실무 코칭 프로그래밍 Book의 첫번째 책으로, 오라클 11g의 새로운 ...');
insert into product values(product_seq.nextval, 'Visual C++ MFC 윈도우 프로그래밍', 26000, 'mfc.jpg', 'Visual C++를 처음 시작하는 독자의 눈높이에 맞춘 Visual C++...');
insert into product values(product_seq.nextval, 'jQuery and jQuery Mobile : 이해하기 쉽게 풀어쓴', 25000, 'jquery.jpg', '소스 하나로 데스크탑과 모바일까지 HTML5와 함께 사용한다. 초보자들도 ...');

select * from product;
select * from product order by code desc;
delete from product where code='14';
update product set name='', price='', pictureurl='', description='' where code='';

-- 커밋
commit;

create table movie (
    code number(4),
    title varchar2(50),
    price number(10),
    director varchar2(20),
    actor varchar2(20),
    poster varchar2(100),
    synopsis varchar2(3000),
    PRIMARY KEY (code)
);

create SEQUENCE movie_sequ start with 1 INCREMENT by 1;
insert into movie values(movie_sequ.nextval, '베를린', 10000, '류승완', '하정우', 'movie1.jsp', '거대한 국제적 음모가 숨겨진 운명의 도시 베를린');
insert into movie values(movie_sequ.nextval, '박수건달', 10000, '조진규', '박신양, 엄지원', 'movie2.jsp', '건달로 사느냐 무당으로 사느냐');
insert into movie values(movie_sequ.nextval, '레미제라블', 10000, '톰 후퍼', '휴 잭맨', 'movie3.jsp', '빵 한 조각을 훔친 죄로 19년을 감옥살이');
insert into movie values(movie_sequ.nextval, '7번방의 선물', 9000, '이환경', '류승룡, 갈소원', 'movie4.jsp', '최악의 흉악범들이 모인 교도소 7번방');

select * from movie order by code desc;

COMMIT;

