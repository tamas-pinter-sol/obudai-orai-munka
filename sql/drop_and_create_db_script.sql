
    drop table book cascade constraints;

    drop sequence book_seq;

    create table book (
        id number(10,0) not null,
        author varchar2(255 char),
        description varchar2(255 char),
        name varchar2(50 char),
        pub_year number(10,0),
        primary key (id)
    );

    create sequence book_seq;
