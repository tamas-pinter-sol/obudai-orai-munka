create table book(
 id number,
 name VARCHAR2(50),
 description VARCHAR2(200),
 author VARCHAR2(100),
 pub_year number(4)
);
/

CREATE SEQUENCE book_seq
 START WITH     3
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
/