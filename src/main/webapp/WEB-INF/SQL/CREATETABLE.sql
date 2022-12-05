C:\Users\302-00>SQLPLUS /NOLOG
SQL> CONN /AS SYSDBA
연결되었습니다.
SQL> SHOW USER
USER은 "SYS"입니다
SQL> ALTER SESSION SET "_ORACLE_SCRIPT"=true;
세션이 변경되었습니다.

SQL> CREATE USER TBOARD IDENTIFIED BY 1234;
사용자가 생성되었습니다.

SQL> GRANT CONNECT, RESOURCE TO TBOARD;
권한이 부여되었습니다.

SQL> ALTER USER BOARD DEFAULT TABLESPACE
  2  USERS QUOTA UNLIMITED ON USERS;
사용자가 변경되었습니다.

-------------------------------------------------------
menus
    MENU_ID  MENU_NAME  MENU_SEQ
    MENU01   JAVA       2
    MENU02   JSP        3     
    MENU03   HTML       1
    MENU04   SPRING     4

BOARD
    IDX     TITLE            MENU_ID
    3      SPRING  소개     MENU04 
    1      JAVA 1강         MENU01
    2       [RE] 어려워요   MENU01
    


-------------------------------------------------------
-- MENUS  테이블 생성
-------------------------------------------------------
CREATE TABLE MENUS
(
     MENU_ID     VARCHAR2(6)   NOT  NULL  PRIMARY KEY    
   , MENU_NAME   VARCHAR2(120) NOT  NULL
   , MENU_SEQ    NUMBER(5, 0)  NOT  NULL
)

INSERT INTO MENUS ( MENU_ID, MENU_NAME, MENU_SEQ)
 VALUES  ('MENU01', 'JAVA', 1);
COMMIT; 

-----------------------------------------------------------
-- 게시물 목록
-----------------------------------------------------------
CREATE  TABLE  BOARD
(
      IDX           NUMBER( 5, 0 )    PRIMARY KEY
    , MENU_ID       VARCHAR2(6)       NOT NULL
        REFERENCES   MENUS (MENU_ID) 
    , TITLE         VARCHAR2(300)     NOT NULL
    , CONT          VARCHAR2(4000) 
    , WRITER        VARCHAR2(50) 
    , REGDATE       DATE              DEFAULT  SYSDATE
    , READCOUNT     NUMBER( 6, 0 )    DEFAULT  0
    
    , BNUM          NUMBER( 5, 0 )    DEFAULT  0
    , LVL           NUMBER( 5, 0 )    DEFAULT  0
    , STEP          NUMBER( 5, 0 )    DEFAULT  0
    , NREF          NUMBER( 5, 0 )    DEFAULT  0
)

DROP TABLE BOARD;

-------------------------------------
--  자료실 위한 FILES 테이블
-------------------------------------
CREATE   TABLE    FILES
(
    FILE_NUM     NUMBER(6, 0)  NOT NULL   -- 파일번호
   , IDX         NUMBER(5, 0)  NOT NULL   -- 게시글 번호
   , FILENAME    VARCHAR2(300) NOT NULL   -- 파일명
   , FILEEXT     VARCHAR2(100) NOT NULL   -- 파일확장자
   , SFILENAME   VARCHAR2(300) NOT NULL   -- 저장된 실제 파일명
   
   , CONSTRAINT  FILES_PK     PRIMARY KEY  -- 기본키(복합키) 
     (
          FILE_NUM,
          IDX
     ) 
   , CONSTRAINT  FK_BOARD_FILES_IDX 
     FOREIGN KEY (IDX)
     REFERENCES  BOARD(IDX)
      ON  DELETE CASCADE
);

--------------------------
--- 사용자정보
--------------------------
CREATE TABLE  TUSER
(
     USERID     VARCHAR2(20)  PRIMARY KEY
   , PASSWD     VARCHAR2(20)  NOT NULL
   , USERNAME   VARCHAR2(60)  NOT NULL
   , INDATE     DATE          DEFAULT SYSDATE
)

INSERT INTO  TUSER ( USERID, PASSWD, USERNAME  )
 VALUES ( 'sky', '1234', '관리자'   );
commit; 














