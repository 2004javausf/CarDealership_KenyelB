--DROP USER kib4885 CASCADE;
--
--
--/*******************************************************************************
--   Create database
--********************************************************************************/
--CREATE USER kib4885
--IDENTIFIED BY apple1950
--DEFAULT TABLESPACE users
--TEMPORARY TABLESPACE temp
--QUOTA 10M ON users;
--
--GRANT connect to kib4885;
--GRANT resource to kib4885;
--GRANT create session TO kib4885;
--GRANT create table TO kib4885;
--GRANT create view TO kib4885;
--
--
--
--conn kib4885/apple1950   



CREATE TABLE CUSTOMER(
CUSTOMER_ID INTEGER PRIMARY KEY, AUTO INCREMENT,
CUSTOMER_FNAME VARCHAR2(50) NOT NULL,
CUSTOMER_LNAME VARCHAR2(50) NOT NULL,
CUSTOMER_UNAME VARCHAR2(15) NOT NULL,
CUSTOMER_PWORD VARCHAR2(15) NOT NULL
)

DROP TABLE CAR_TYPE;
CREATE TABLE  CAR_TYPE(
CAR_TYPE_ID INTEGER PRIMARY KEY NOT NULL,
CAR_TYPE_MAKE VARCHAR2(20) NOT NULL,
CAR_TYPE_MODEL VARCHAR(20)NOT NULL,
CAR_TYPE_COLOR VARCHAR(20)NOT NULL,
CAR_TYPE_YEAR INTEGER NOT NULL,
CAR_TYPE_MILEAGE INTEGER NOT NULL,
CAR_TYPE_TRANSMISSION VARCHAR(20) NOT NULL,
CAR_TYPE_DOOR VARCHAR2(20)NOT NULL,
CAR_TYPE_COST INTEGER NOT NULL,
CAR_TYPE_OWNED VARCHAR2(20)NOT NULL
)

INSERT INTO CAR_TYPE VALUES(1,'GMC', 'ENVOY', 'RED', 2006, 113552, 'AUTOMATIC', '4-DOOR', 3995, 'FALSE');
INSERT INTO CAR_TYPE VALUES(2,'BMW', '650 I', 'GRAY', 2012, 83262, 'AUTOMATIC', '2-DOOR', 15499, 'FALSE');
INSERT INTO CAR_TYPE VALUES(3,'TOYOTA', 'PRIUS V FIVE', 'BLUE', 2012, 11481, 'CVT', '4-DOOR', 9800, 'FALSE');
INSERT INTO CAR_TYPE VALUES(4,'DODGE', 'JOURNEY SE', 'BLACK', 2019, 1200, 'AUTOMATIC', '4-DOOR', 16500, 'FALSE');

CREATE SEQUENCE MYSEQ;
INSERT INTO  STUDENT VALUES (MYSEQ.NEXTVAL, 'TIM', MYSEQ.NEXTVAL);
SELECT * FROM STUDENT;
CREATE TABLE  CUST_ACCT(
CUST_ACCT_ID INTEGER PRIMARY KEY NOT NULL,
CUST_ACCT_FNAME VARCHAR2(50) NOT NULL,
CUST_ACCT_LNAME VARCHAR2(50) NOT NULL,
CUST_ACCT_UNAME VARCHAR2(15) NOT NULL,
CUST_ACCT_PWORD VARCHAR2(15) NOT NULL,
CUST_ACCT_ACCTNUM INTEGER NOT NULL
)