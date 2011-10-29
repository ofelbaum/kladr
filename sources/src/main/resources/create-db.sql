DROP TABLE KLADR;
DROP TABLE STREET;
DROP TABLE DOMA;
DROP TABLE FLAT;
DROP TABLE SOCRBASE;
DROP TABLE ALTNAMES;

CREATE TABLE KLADR (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(40),
    SOCR VARCHAR(10),
	CODE VARCHAR(13),
	POSTINDEX VARCHAR(6),
	GNINMB VARCHAR(4),
	UNO VARCHAR(4),
	OCATD VARCHAR(11),
	STATUS VARCHAR(1)
) TYPE MYISAM CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE STREET (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(40),
  SOCR VARCHAR(10),
  CODE VARCHAR(17),
  POSTINDEX VARCHAR(6),
  GNINMB VARCHAR(4),
  UNO VARCHAR(4),
  OCATD VARCHAR(11)
) TYPE MYISAM CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE DOMA (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(40),
  KORP VARCHAR(10),
  SOCR VARCHAR(10),
  CODE VARCHAR(19),
  POSTINDEX	VARCHAR(6),
  GNINMB VARCHAR(4),
  UNO	VARCHAR(4),
  OCATD VARCHAR(11)
) TYPE MYISAM CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE FLAT (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(40),
  CODE VARCHAR(23),
  POSTINDEX VARCHAR(6),
  GNINMB VARCHAR(4),
  UNO VARCHAR(4),
  NP VARCHAR(4)
) TYPE MYISAM CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE SOCRBASE (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  LEVEL VARCHAR(5),
  SCNAME VARCHAR(10),
  SOCRNAME VARCHAR(29),
  KOD_T_ST VARCHAR(3)
) TYPE MYISAM CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE ALTNAMES (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  OLDCODE VARCHAR(19),
  NEWCODE VARCHAR(19),
  LEVEL VARCHAR(1)
) TYPE MYISAM CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE UNIQUE INDEX STREET_CODE_INDEX ON STREET(ID, CODE);
CREATE UNIQUE INDEX KLADR_CODE_INDEX ON KLADR(ID, CODE);

COMMIT;

