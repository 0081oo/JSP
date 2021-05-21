DROP TABLE account;
DROP SEQUENCE account_seq;

CREATE SEQUENCE account_seq NOCACHE;
CREATE TABLE account(
	id NUMBER,
	nickname NVARCHAR2(64),
	username NVARCHAR2(64),
	password NVARCHAR2(64),
	email NVARCHAR2(128),
	gender CHAR(1),
	age NUMBER,
	joindate DATE DEFAULT SYSDATE,
	logindate DATE DEFAULT SYSDATE,
	expiredate DATE DEFAULT NULL;
);

/*
 *  제약조건 따로 설정
 */
ALTER TABLE account ADD CONSTRAINT account_id_PK PRIMARY KEY(id);
ALTER TABLE account MODIFY nickname CONSTRAINT account_nickname_NN NOT NULL;
ALTER TABLE account MODIFY username CONSTRAINT account_username_NN NOT NULL;
ALTER TABLE account MODIFY password CONSTRAINT account_password_NN NOT NULL;
ALTER TABLE account MODIFY age CONSTRAINT account_age_NN NOT NULL;
ALTER TABLE account MODIFY email CONSTRAINT account_email_NN NOT NULL;
ALTER TABLE account ADD CONSTRAINT account_gender_CK CHECK(gender in ('m', 'w'));

COMMENT ON COLUMN account.id IS '사용자 계정 식별 번호';
COMMENT ON COLUMN account.nickname IS '사용자 계정 식별 번호';
COMMENT ON COLUMN account.email IS '사용자 이메일 주소 (로그인 아이디)';