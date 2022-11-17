DROP DATABASE IF EXISTS ch_app_2022_10_13;
CREATE DATABASE ch_app_2022_10_13;
USE ch_app_2022_10_13;

# 게시물 테이블 생성
CREATE TABLE article(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(100) NOT NULL,
	`body` TEXT NOT NULL
);

# 게시물, 테스트 데이터 생성
INSERT INTO article
SET regdate = NOW(),
updateDate = NOW(),
title = "제목1",
`body` = "내용1";

INSERT INTO article
SET regdate = NOW(),
updateDate = NOW(),
title = "제목2",
`body` = "내용2";

INSERT INTO article
SET regdate = NOW(),
updateDate = NOW(),
title = "제목3",
`body` = "내용3";

SELECT LAST_INSERT_ID();


# 회원 테이블 생성
CREATE TABLE `member`(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	loginId CHAR(20) UNIQUE NOT NULL,
	loginPw CHAR(60) NOT NULL,
	`authLevel` SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '권한레벨(3=일반, 7=관리자)',
	`name` CHAR(20) NOT NULL,
	nickname CHAR(20) NOT NULL,
	cellphoneNo CHAR(20) NOT NULL,
	email CHAR(50) NOT NULL,
	delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴여부(0=탈퇴전, 1=탈퇴)',
	delDate DATETIME COMMENT '탈퇴날짜'
);

# 회원 테스트 데이터 생성(관리자)
INSERT INTO `member`
SET regdate = NOW(),
updateDate = NOW(),
loginId = "admin",
loginPw = "admin",
`authLevel` = 7,
`name` = "관리자",
nickname = "관리자",
cellphoneNo = "010-4828-1573",
email = "chang2210@naver.com";

# 회원 테스트 데이터 생성(일반 회원)
INSERT INTO `member`
SET regdate = NOW(),
updateDate = NOW(),
loginId = "user1",
loginPw = "user1",
`name` = "user1",
nickname = "user1",
cellphoneNo = "010-4828-1573",
email = "chang2210@naver.com";

INSERT INTO `member`
SET regdate = NOW(),
updateDate = NOW(),
loginId = "user2",
loginPw = "user2",
`name` = "user2",
nickname = "user2",
cellphoneNo = "010-4828-1573",
email = "chang2210@naver.com";

