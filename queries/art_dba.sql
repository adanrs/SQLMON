prompt
prompt ******************************************************
prompt Get server RAM Size
prompt ******************************************************
col c1 heading 'Physical|Memory|MB' format 999,999,999
select
   max(value)/1024/1024 c1
from
   dba_hist_osstat
where
   stat_name = 'PHYSICAL_MEMORY_BYTES';
prompt
prompt ******************************************************
prompt Get server minimum Free RAM Size
prompt ******************************************************
col c1 heading 'Minimum|Physical|Free|Memory|MB' format 999,999,999
select
   min(value)/1024/1024 c1
from
   dba_hist_osstat
where
   stat_name ='FREE_MEMORY_BYTES';
prompt
prompt ******************************************************
prompt Get server maximum Free RAM Size
prompt ******************************************************
col c1 heading 'Maximum|Physical|Free|Memory|MB' format 999,999,999
select
   max(value)/1024/1024 c1
from
   dba_hist_osstat
where
   stat_name ='FREE_MEMORY_BYTES';