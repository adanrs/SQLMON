
SET VERIFY OFF

SELECT table_name, monitoring 
FROM   dba_tables
WHERE  owner = UPPER('&1')
AND    table_name = DECODE(UPPER('&2'), 'ALL', table_name, UPPER('&2'));
