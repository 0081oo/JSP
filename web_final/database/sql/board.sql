DROP TABLE board;
DROP SEQUENCE board_seq;

/*
 * 게시판 종류 테이블
 */
CREATE TABLE board_type(
	id NUMBER,
	name NVARCHAR2(256)
);

ALTER TABLE board_type ADD CONSTRAINT board_type_id_PK PRIMARY KEY(id);
ALTER TABLE board_type MODIFY name CONSTRAINT board_type_name_NN NOT NULL;

COMMENT ON COLUMN board_type.id IS '게시판 구분 식별 번호';
COMMENT ON COLUMN board_type.name IS '게시판 종류';

INSERT INTO board_type VALUES(1, '자유 게시판');
INSERT INTO board_type VALUES(2, '유머 게시판');
INSERT INTO board_type VALUES(3, '정치/사회 게시판');

CREATE SEQUENCE board_Seq NOCACHE;
CREATE TABLE board(
	id NUMBER,
	btype NUMBER,
	aid NUMBER,
	title NVARCHAR2(256),
	contents NCLOB,
	vcnt NUMBER DEFAULT 0,
	gcnt NUMBER DEFAULT 0,
	bcnt NUMBER DEFAULT 0,
	cdate DATE DEFAULT SYSDATE
	udate DATE DEFAULT SYSDATE,
	nodel CHAR(1) DEFAULT 'n',
	deleted CHAR(1) DEFAULT 'n'
);

ALTER Table board ADD CONSTRAINT board_id_PK PRIMARY KEY(id);
ALTER TABLE board ADD CONSTRAINT board_btype_FK FOREIGN KEY(btype) REFERENCES board_type(id);
ALTER TABLE board ADD CONSTRAINT board_aid_FK FOREIGN KEY(aid) REFERENCES account(id);
ALTER TABLE board MODIFY title CONSTRAINT board_title_NN NOT NULL;
ALTER TABLE board ADD CONSTRAINT board_nodel_CK CHECK(nodel in ('n', 'y'));
ALTER TABLE board ADD CONSTRAINT board_deleted_CK CHECK(deleted in ('n', 'y'));

COMMENT ON COLUMN board.aid IS '게시판 작성자 식별 번호';
COMMENT ON COLUMN board.vcnt IS '조회수';
COMMENT ON COLUMN board.gcnt IS '추천수';
COMMENT ON COLUMN board.bcnt IS '비추천수';
COMMENT ON COLUMN board.nodel IS '게시판 삭제 금지 구분(y인경우 작성자도 삭제 불가)';
COMMENT ON COLUMN board.deleted IS '게시판 삭제 구분(y인경우 삭제된 것으로 간주)';

/*
 * 첨부파일용 테이블
 */
CREATE SEQUENCE attach_files_seq NOCACHE;
CREATE TABLE attach_filesO
	id NUMBER,
	bid NUMBER,
	name NVARCHAR2(512) NOT NULL,
	path NVARCHAR2(2048) NOT NULL,
	url NVARCHAR2(2048) NOT NULL
;

ALTER TABLE attach_files ADD CONSTRAINT attach_files_PK PRIMARY KEY(id);
ALTER TABLE attach_files ADD CONSTRAINT attach_files_bid_FK FOREIGN KEY(bid) REFERENCES board(id);

/*
 *  댓글 테이블
 */
CREATE SEQUENCE comment_seq NOCACHE;
CREATE TABLE comment(
	id NUMBER IS PRIMARY KEY,
	bid NUMBER,
	aid NUMBER,
	contents NVARCHAR2(2048),
	gcnt NUMBER DEFAULT 0,
	bcnt NUMBER DEFAULT 0,
	cdate DATE DEAULT SYSDATE,
	udate DATE DEFAULT SYSDATE,
	deleted CHAR(1) DEFAULT 'n'
);

ALTER TABLE comment ADD CONSTRAINT comment_bid_FK FOREIGN KEY(bid) REFERENCES board(id);
ALTER TABLE comment ADD CONSTRAINT comment_aid_FK FOREIGN KEY(aid) REFERENCES account(id);

SELECT DBMS_LOB.SUBSTR(contents, DBMS_LOB.GETLENGTH(contents)) as contents FROM board;
SELECT DBMS_LOB.SUBSTR(contents, 3) as contents FROM board;
SELECT TO_CHAR(contents) as contents FROM board;


SELECT a.id,
	a.btype,
	b.name AS bname,
	a.aid,
	a.title,
	a.cdate,
	a.vcnt
FROM board a
JOIN board_type b
	ON a.btype = b.id
JOIN account c
	ON a.aid = c.id;


SELECT * FROM board_type;
SELECT * FROM account;