create table tbl_board (
    bno number(10,0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    updatedate date default sysdate
    );
    
alter table tbl_board add CONSTRAINT pk_board primary key(bno);
CREATE SEQUENCE seq_board INCREMENT BY 1;
insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, '테스트 제목', '테스트 내용', 'user00');

select * from tbl_board order by bno asc;

select seq_board.currval from dual; -- 시퀀스 조회