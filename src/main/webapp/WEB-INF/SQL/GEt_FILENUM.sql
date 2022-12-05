
--GET_FILENUM() 가능
--  ( SELECT NVL( MAX(FILE_NUM), 0)+1 FROM FILES ),  PK 위반 x
--  FILENUM_SEQ.NEXTVAL, PK 위반 X

-- 시퀀스
CREATE SEQUENCE FILENUM_SEQ;

-- 함수
CREATE  OR REPLACE FUNCTION  GET_FILENUM
RETURN 
   NUMBER   AS NUM  NUMBER;
BEGIN
   SELECT     FILENUM_SEQ.NEXTVAL
     INTO     NUM
     FROM     DUAL;
     RETURN   NUM;                                                             
END;
/
 



 -->
