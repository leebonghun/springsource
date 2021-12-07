create table spring_board(
	bno number(10,0),				--글번호
	title varchar2(200) not null,   --제목
	content varchar2(2000) not null,--내용
	writer varchar(50) not null,    --작성자
	regdate date default sysdate,   --작성날짜
	updatedate date default sysdate --수정날짜
);

alter table spring_board add constraint pk_spring_board primary key(bno);

create sequence seq_board;

select * from spring_board;

--페이지 나누기
--rownum(가상 행번호)
--더미 데이터 삽입
insert into spring_board(bno,title,content,writer)
(select seq_board.nextval,title,content,writer from SPRING_BOARD);

select count(*) from SPRING_BOARD;

select rownum,bno,title from spring_board order by bno asc;

--rownum부여시 주의할 점 order by 절과 같이 올때(order by 구문에 index값이 쓰이지 않는 경우)
--order by re_ref desc, re_lev asc;
--index(pk 만들면 index 로 생성됨)

--서브쿼리 이용하기
select bno,title 
from (select bno,title from SPRING_BOARD where bno>0 order by bno desc) 
where rownum <= 10;


--오라클 힌트 이용하기
select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum,bno,title
from SPRING_BOARD
where rownum <=10;

--1 : 최신글 10개 가지고 나오기

select rn,bno,title
from(select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum rn,bno,title
	from SPRING_BOARD
	where rownum <=10)
where rn>0;


--2 : 그 다음 최신글 10개 가지고 나오기
select rn,bno,title
from(select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum rn,bno,title
	from SPRING_BOARD
	where rownum <=20)
where rn>10;


--검색

--제목/내용/작성자 단일항목 검색
select rn,bno,title
from(select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum rn,bno,title
	from SPRING_BOARD
	--우선순위를 확실하게 줘라
	where (title like '%asd%' or content like '%asd%') and rownum <=20)
where rn>10;

--MyBatis 동적 태그

--제목 or 내용/ 제목 or 작성자 / 제목 or 내용 or 작성자

--댓글테이블
create table spring_reply(
   rno number(10,0) constraint pk_reply primary key, -- 댓글 글번호
   bno number(10,0) not null,   -- 원본 글번호
   reply varchar2(1000) not null,   --댓글 내용
   replayer varchar2(50) not null,   --댓글 작성자
   replaydate date default sysdate,   --댓글 작성일
   updatedate date default sysdate,   --댓글 수정일
   constraint fk_reply_board foreign key(bno) references spring_board(bno)
);

create sequence seq_reply;

alter table spring_reply RENAME COLUMN replayer to replyer;

select * from spring_reply;


--인덱스 생성
create index idx_reply on spring_reply(bno desc, rno asc);

select rno,bno,reply,replyer,replydate,updatedate 
from(select /*+INDEX(spring_reply idx_reply)*/rownum rn,rno,bno,reply,replyer,replydate,updatedate from spring_reply where bno =506 and rno>0 and rownum<=20)
where rn >10;