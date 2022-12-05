create or replace PACKAGE BODY PKG_PDS2 AS

  PROCEDURE   PROC_PDS_LIST(
        IN_MENU_ID     IN     VARCHAR2,
        O_CUR          OUT    SYS_REFCURSOR 
    ) AS
  BEGIN
     
     OPEN  O_CUR  FOR
        SELECT       IDX,   MENU_ID,
                     LPAD(' ', LVL*2 ) ||  DECODE( LVL, 0, '', '[답변]'  )
                       ||   TITLE AS TITLE,
                     WRITER,  REGDATE, READCOUNT,
                     BNUM, LVL, STEP, NREF,
                     DELNUM,
                     ( SELECT  COUNT(FILE_NUM) FROM FILES  F 
                       WHERE  B.IDX = F.IDX )
                       AS  FILESCOUNT
         FROM        MBOARD   B  
         WHERE       MENU_ID  =  IN_MENU_ID
         ORDER BY    NREF DESC,  STEP  ASC;
     
  END PROC_PDS_LIST;

-- 새글/답글 추가( MBOARD) + 파일정보 저장(files)
  PROCEDURE   PROC_PDS_INSERT(
        IN_MENU_ID     IN    VARCHAR2,
        IN_TITLE       IN    VARCHAR2,
        IN_CONT        IN    VARCHAR2,
        IN_WRITER      IN    VARCHAR2,
        IN_BNUM        IN    INTEGER,
        IN_LVL         IN    INTEGER,
        IN_STEP        IN    INTEGER,
        IN_NREF        IN    INTEGER,
        
        -- 파일 업로드에 대한 추가 항목
        IN_FILENAME    IN     FILE_ARRAY,
        IN_FILEEXT     IN     FILE_ARRAY,
        IN_SFILENAME   IN     FILE_ARRAY
    ) AS
        V_BNUM         NUMBER(5, 0)  := 0;
        V_LVL          NUMBER(5, 0);
        V_STEP         NUMBER(5, 0);
        V_NREF         NUMBER(5, 0);    
        
        V_MAXIDX       NUMBER(5, 0);    
  BEGIN
    
    -- INSERT MBOARD : 새글/답글 저장
    IF   IN_BNUM  = 0 THEN
       -- 새글 입력
       -- 글번호 생성
        SELECT  NVL( MAX(BNUM), 0 ) + 1  
         INTO   V_BNUM  
         FROM   MBOARD
         WHERE  MENU_ID  = IN_MENU_ID;
       
        V_LVL    :=     0; 
        V_STEP   :=     0; 
       
         SELECT  NVL( MAX(NREF), 0 ) + 1  
         INTO   V_NREF  
         FROM   MBOARD
         WHERE  MENU_ID  = IN_MENU_ID;
       
    ELSE
       -- 답글 입력
        V_BNUM    :=  IN_BNUM;
        V_LVL     :=  IN_LVL  + 1;
        V_STEP    :=  IN_STEP + 1;
        V_NREF    :=  IN_NREF;
        
        -- 기존글들의 순서를 변경
        -- 입력된 글의 STEP과 같거나 큰 글들의 숫자 + 1
        UPDATE     MBOARD
         SET       STEP     =  STEP + 1
         WHERE     NREF     =  IN_NREF
          AND      STEP     >  IN_STEP
          AND      MENU_ID  =  IN_MENU_ID;
    
    END IF;
    
    INSERT INTO MBOARD (
        IDX,
        MENU_ID,
        TITLE,
        CONT,
        WRITER,
        REGDATE,
        READCOUNT,
        BNUM,
        LVL,
        STEP,
        NREF,
        DELNUM
    ) values (
        ( SELECT NVL( MAX(IDX), 0) + 1  
          FROM   MBOARD  ),
        IN_MENU_ID,
        IN_TITLE,
        IN_CONT,
        IN_WRITER,
        SYSDATE,
        0,
        V_BNUM,
        V_LVL,
        V_STEP,
        V_NREF,
        0
    );
    
    ----------------------------------------
    -- 방금 추가된 글 반호
    SELECT  MAX(IDX)
     INTO   V_MAXIDX
     FROM   MBOARD;
     
        
    -- INSERT FILES : 첨부파일 목록 저장, 김연아.jpg, 제시.jpg, 아이유.jpg 
    -- 배열 1 부터 시작
    IF  IN_FILENAME( 1 ) IS NOT NULL THEN
        FOR  I  IN   IN_FILENAME.FIRST .. IN_FILENAME.LAST 
        LOOP
           INSERT  INTO FILES 
           VALUES (
              (  SELECT  NVL( MAX(FILE_NUM), 0 ) + 1 FROM FILES)    -- FILES 의 일렵번호
             ,  V_MAXIDX                                            -- 게시판 번호(추가된 글번호)
             ,  IN_FILENAME( I )                                    -- 파일이름(1)
             ,  IN_FILEEXT( I )                                     -- 확장자(1)
             ,  IN_SFILENAME( I )                                -- 실제파일명(1) 
           );
        END LOOP;
        
    END IF;
    
  END PROC_PDS_INSERT;

  PROCEDURE    PROC_PDS_VIEW (
        IN_IDX        IN      NUMBER,
        O_CUR         OUT     SYS_REFCURSOR
    ) AS
  BEGIN
    
     --  조회수 증가
     UPDATE   MBOARD
      SET     READCOUNT  =  READCOUNT + 1
      WHERE   IDX        =  IN_IDX;
     COMMIT;  
    
     -- 조회
     OPEN  O_CUR  FOR
       SELECT
            IDX,
            MENU_ID,
            TITLE,
            CONT,
            WRITER,
            REGDATE,
            READCOUNT,
            BNUM,
            LVL,
            STEP,
            NREF,
            DELNUM
        FROM
            MBOARD
        WHERE 
            IDX    =  IN_IDX; 
    
  END PROC_PDS_VIEW;

  PROCEDURE   PROC_PDS_FILELIST (
        IN_IDX        IN      NUMBER,
        O_CUR         OUT     SYS_REFCURSOR
    ) AS
  BEGIN
    
     OPEN  O_CUR  FOR
        SELECT
            FILE_NUM,
            IDX,
            FILENAME,
            FILEEXT,
            SFILENAME
        FROM
            FILES
        WHERE 
            IDX  = IN_IDX
        ORDER  BY  FILE_NUM ASC;    
    
  END PROC_PDS_FILELIST;

  PROCEDURE   PROC_PDS_PAGINGLIST(
       IN_MENU_ID       IN     VARCHAR2,
       
       IN_NOWPAGE       IN     NUMBER,
       IN_PAGECOUNT     IN     NUMBER,
       
       OUT_TOTALCOUNT   OUT    NUMBER,
       
       O_CUR            OUT    SYS_REFCURSOR
    
    ) AS
      V_STARTNUM    NUMBER(10, 0);    -- 페이징된 자료의 시작번호 :  RECORD 번호
      V_ENDNUM      NUMBER(10, 0);    -- 페이징된 자료의 끝번호 :  RECORD 번호
  BEGIN
    
    --  페이징처리를 위한 전채자료수(현재 메뉴정보만큼)
     SELECT   NVL(COUNT( IDX ), 0)
      INTO    OUT_TOTALCOUNT
      FROM    MBOARD
      WHERE   MENU_ID   =  IN_MENU_ID; 
     
      --  가져올 자료(레코드)의 시작번호, 끝번호
      V_STARTNUM :=   ( IN_NOWPAGE - 1  ) * IN_PAGECOUNT + 1;
      V_ENDNUM   :=   IN_NOWPAGE * IN_PAGECOUNT; 
      --    V_ENDNUM    :=   V_STARTNUM + IN_PAGECOUNT - 1 
          
    
      -- DATA 가져오기
      OPEN  O_CUR   FOR
        SELECT   *  FROM (
         SELECT
           ROW_NUMBER() OVER (ORDER BY NREF DESC, STEP ASC) AS RN, 
           IDX, MENU_ID,
           TITLE  AS TITLE,
           WRITER, REGDATE, READCOUNT,
           ( SELECT    NVL(COUNT(FILENAME), 0)  FROM   FILES F 
              WHERE    F.IDX = B.IDX  ) AS FILESCOUNT,
           BNUM, LVL, STEP, NREF, DELNUM
        FROM   MBOARD  B
        WHERE  MENU_ID  = IN_MENU_ID
        ) T
        WHERE  T.RN   BETWEEN  V_STARTNUM AND  V_ENDNUM 
         ORDER BY   NREF  DESC,  STEP  ASC;
    
  END PROC_PDS_PAGINGLIST;

  --  수정     PROC_PDS_UPDATE
  PROCEDURE    PROC_PDS_UPDATE(
        IN_IDX         IN      NUMBER,
        IN_TITLE       IN      VARCHAR2,
        IN_CONT        IN      VARCHAR2,
        
        IN_FILENAME    IN      FILE_ARRAY,
        IN_FILEEXT     IN      FILE_ARRAY,
        IN_SFILENAME   IN      FILE_ARRAY
    ) AS
  BEGIN
      
      UPDATE    MBOARD
       SET      TITLE   =   IN_TITLE,
                CONT    =   IN_CONT
       WHERE    IDX     =   IN_IDX;
       
     -- 파일 업로드 추가 부분
      IF  IN_FILENAME(1)  IS NOT NULL THEN
        FOR  I   IN   IN_FILENAME.FIRST .. IN_FILENAME.LAST 
        LOOP
            INSERT   INTO  FILES
            VALUES
            (
                ( SELECT NVL(MAX(FILE_NUM), 0)+1 FROM  FILES )
                ,  IN_IDX
                ,  IN_FILENAME  ( I ) 
                ,  IN_FILEEXT   ( I )
                ,  IN_SFILENAME ( I )
            );
        END LOOP;
      END IF;
      
      COMMIT; 
      
      
  END PROC_PDS_UPDATE;

  PROCEDURE     PROC_PDS_DELETE(
        IN_IDX         IN      NUMBER,
        IN_NREF        IN      NUMBER,
        IN_LVL         IN      NUMBER,
        IN_STEP        IN      NUMBER    
    ) AS
  BEGIN
   
     -- DELNUM = 1 로 수정 :  IDX 의 DELNUM = 1
     UPDATE   MBOARD
       SET    DELNUM  = 1
       WHERE  IDX     =  IN_IDX;
     
     -- 실제 자료의 삭제 -- 답글이 없을때
     -- 2. FILES 테이블의 자룔르 삭제
       DELETE  FROM  FILES
        WHERE  IDX  =   IN_IDX
         AND    NOT  EXISTS
         (
             SELECT  1   FROM  MBOARD
              WHERE  NREF   =   IN_NREF
               AND   LVL    =   IN_LVL   + 1
               AND   STEP   =   IN_STEP  + 1
         );
        
     -- 1. MBOARD 자려 삭제
        DELETE  FROM  MBOARD
        WHERE  IDX  =   IN_IDX
         AND    NOT  EXISTS
         (
             SELECT  1   FROM  MBOARD
              WHERE  NREF   =   IN_NREF
               AND   LVL    =   IN_LVL   + 1
               AND   STEP   =   IN_STEP  + 1
         );
        
      COMMIT;
   
  END PROC_PDS_DELETE;

END PKG_PDS2;