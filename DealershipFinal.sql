DROP USER sunny CASCADE;

CREATE USER sunny
IDENTIFIED BY water
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to sunny;
GRANT resource to sunny;
GRANT create session TO sunny;
GRANT create table TO sunny;
GRANT create view TO sunny;
conn sunny/water


DROP TABLE NEW_CUSTOMER;
CREATE TABLE NEW_CUSTOMER(
C_FNAME VARCHAR2(50) NOT NULL,
C_LNAME VARCHAR2(50) NOT NULL,
C_UNAME VARCHAR2(15) PRIMARY KEY ,
C_PWORD VARCHAR2(15) NOT NULL
)


DROP TABLE NEW_ACCOUNT;
CREATE TABLE NEW_ACCOUNT(
C_ACCT INTEGER PRIMARY KEY,
C_ID INTEGER,
C_UNAME VARCHAR2(15),
C_BAL INTEGER,
C_DUEPAY INTEGER,
C_TERMS INTEGER
)


ALTER TABLE NEW_ACCOUNT
ADD FOREIGN KEY (C_ID ) REFERENCES CAR_TYPE(CAR_TYPE_ID);

ALTER TABLE NEW_ACCOUNT
ADD FOREIGN KEY (C_UNAME) REFERENCES NEW_CUSTOMER(C_UNAME);


DROP TABLE OFFER;
CREATE TABLE OFFER(
O_ID INTEGER PRIMARY KEY,
O_CAR_ID INTEGER,
O_UNAME VARCHAR2(20),
O_AMOUNT INTEGER,
O_STATUS VARCHAR2(20)
)

ALTER TABLE OFFER
ADD FOREIGN KEY (O_CAR_ID) REFERENCES CAR_TYPE(CAR_TYPE_ID);
ALTER TABLE OFFER
ADD FOREIGN KEY (O_UNAME) REFERENCES NEW_CUSTOMER(C_UNAME);

DROP TABLE CAR_TYPE;
CREATE TABLE  CAR_TYPE(
CAR_TYPE_ID INTEGER PRIMARY KEY,
CAR_TYPE_MAKE VARCHAR2(20),
CAR_TYPE_MODEL VARCHAR(20),
CAR_TYPE_COLOR VARCHAR(20),
CAR_TYPE_YEAR INTEGER ,
CAR_TYPE_MILEAGE INTEGER ,
CAR_TYPE_TRANSMISSION VARCHAR(20) ,
CAR_TYPE_DOOR VARCHAR2(20),
CAR_TYPE_COST INTEGER ,
CAR_TYPE_OWNED VARCHAR2(20)
)


DROP SEQUENCE ACCTSEQ;
CREATE SEQUENCE ACCTSEQ
MINVALUE 10000001
START WITH 10005201
INCREMENT BY 1
CACHE 5;

DROP SEQUENCE IDSEQ;
CREATE SEQUENCE IDSEQ
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 5;



