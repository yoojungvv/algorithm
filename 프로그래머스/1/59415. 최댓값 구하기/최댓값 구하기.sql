-- 코드를 입력하세요
SELECT DATETIME AS 시간
    FROM (SELECT DATETIME FROM ANIMAL_INS ORDER BY DATETIME DESC)
    WHERE ROWNUM =1; 
    