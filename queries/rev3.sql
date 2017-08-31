 set linesize 100;

SELECT TO_CHAR(BEGIN_TIME, 'MM/DD/YYYY HH24:MI:SS') BEGIN_TIME,
  TO_CHAR(END_TIME, 'MM/DD/YYYY HH24:MI:SS') END_TIME,
  UNDOTSN, UNDOBLKS, TXNCOUNT, MAXCONCURRENCY AS "MAXCON"
FROM v$UNDOSTAT WHERE rownum <= 100;