select
  a.tablespace_name,
  sum(a.bytes)/(1024*1024) total_space_MB,
  round(b.free,2) Free_space_MB,
  round(b.free/(sum(a.bytes)/(1024*1024))* 100,2) percent_free
 from dba_data_files a,
  (select tablespace_name,sum(bytes)/(1024*1024) free  from dba_free_space
  group by tablespace_name) b
 where a.tablespace_name = b.tablespace_name(+)
  group by a.tablespace_name,b.free;