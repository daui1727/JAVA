create table product(
    code number(5),
    name varchar2(100),
    price number(8),
    pictureurl varchar(50),
    description varchar(1000),
    PRIMARY KEY (code)
);

create SEQUENCE product_seq start with 1 INCREMENT by 1;

insert into product values(product_seq.nextval, '������ ���� ����ִ� �����ͺ��̽�', 27000, 'db.jpg', '�����ͺ��̽��� ���� ��� ���� ���� ����ְ� ������ ����...');
insert into product values(product_seq.nextval, '��ǥ���� ���� HTML5', 25000, 'html5.jpg', 'HTML5 ���̵��. Ȩ������ ������ ���� �ʼ� ���� HTML �⺻ ����...');
insert into product values(product_seq.nextval, 'Dynamic Programming book �ø���-01 ����Ŭ 11g + PL/SQL', 25000, 'oracle.jpg','Dynamic �ǹ� ��Ī ���α׷��� Book�� ù��° å����, ����Ŭ 11g�� ���ο� ...');
insert into product values(product_seq.nextval, 'Visual C++ MFC ������ ���α׷���', 26000, 'mfc.jpg', 'Visual C++�� ó�� �����ϴ� ������ �����̿� ���� Visual C++...');
insert into product values(product_seq.nextval, 'jQuery and jQuery Mobile : �����ϱ� ���� Ǯ�', 25000, 'jquery.jpg', '�ҽ� �ϳ��� ����ũž�� ����ϱ��� HTML5�� �Բ� ����Ѵ�. �ʺ��ڵ鵵 ...');

select * from product;
select * from product order by code desc;
delete from product where code='14';
update product set name='', price='', pictureurl='', description='' where code='';

-- Ŀ��
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
insert into movie values(movie_sequ.nextval, '������', 10000, '���¿�', '������', 'movie1.jsp', '�Ŵ��� ������ ���� ������ ����� ���� ������');
insert into movie values(movie_sequ.nextval, '�ڼ��Ǵ�', 10000, '������', '�ڽž�, ������', 'movie2.jsp', '�Ǵ޷� ����� �������� �����');
insert into movie values(movie_sequ.nextval, '���������', 10000, '�� ����', '�� ���', 'movie3.jsp', '�� �� ������ ��ģ �˷� 19���� ��������');
insert into movie values(movie_sequ.nextval, '7������ ����', 9000, '��ȯ��', '���·�, ���ҿ�', 'movie4.jsp', '�־��� ��ǹ����� ���� ������ 7����');

select * from movie order by code desc;

COMMIT;

