column c1 heading "start|time" format a20; 
column c2 heading "end|time" format a20; 
column c3 heading "total|undo|blocks|used" format 9,999,999; 
column c4 heading "total|number of|transactions|executed" format 999,999; 
column c5 heading "longest|query|(sec)" format 999,999; 
column c6 heading "highest|concurrent|transaction|count" format 9,999; 


break on report 
compute sum of c3 on report 
compute sum of c4 on report 

set linesize 120 
select 
to_char(begin_time,'dd-mon-yy hh:mi pm') c1, 
to_char(end_time ,'dd-mon-yy hh:mi pm') c2, 
sum(undoblks) c3, 
sum(txncount) c4, 
max(maxquerylen) c5, 
max(maxconcurrency) c6 
from v$undostat 
group by to_char(begin_time,'dd-mon-yy hh:mi pm'), to_char(end_time ,'dd-mon-yy hh:mi pm') 
order by 1 asc; 