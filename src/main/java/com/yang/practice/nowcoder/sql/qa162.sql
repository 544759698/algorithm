select date_format(in_time, '%Y-%m-%d')                                             as dt,
       round(sum(timestampdiff(second,in_time, out_time)) / count(distinct uid), 1) as avg_viiew_len_sec
from tb_user_log
where in_time >= '2021-11-01'
  and out_time < '2021-12-01'
  and artical_id!=0
group by date_format(in_time, '%Y-%m-%d')
order by avg_viiew_len_sec asc;