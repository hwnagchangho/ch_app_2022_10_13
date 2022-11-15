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
