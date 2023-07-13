select * from Hemu_emp;
select E_number, E_name, E_job, E_hiredate from Hemu_emp
where E_dept=20;

select E_name,E_sal from Hemu_emp
where E_job='Clark';

select  E_name, E_job,E_sal from Hemu_emp
where E_hiredate='1981-02-20';

select E_name, E_sal, E_comm from Hemu_emp
where E_comm>E_sal;

select  E_name, E_sal as monthly_salary, E_sal/22 as daily_salary,E_sal/176 as hourly_salary
from Hemu_emp;

select E_name,E_number from Hemu_emp
where E_job='Manager' and E_sal>2600
order by E_name;

select * from Hemu_emp
where E_job in('Manager','President');

select E_name from Hemu_emp
where E_name not like '%s';

select E_name from Hemu_emp
where E_name like 'C%';

select E_name,E_job,E_dept from Hemu_emp
where E_name between 'C%' and 'f%';

select E_name from Hemu_emp
where E_name like 'l%r';

select E_name from Hemu_emp
where E_name like '%tii%' or E_name like '%ll%';

select * from Hemu_emp
where extract(year from e_hiredate) = 1983;

select E_name || ' has held the position of ' || E_job || ' in department number ' || E_dept || ' since ' || E_hiredate
as display from Hemu_emp;

select * from (select coalesce(null,0) from Hemu_emp where E_comm is null)as Suii;
update Hemu_emp
set E_comm=coalesce(null,0)
where E_comm is null;

select * from Hemu_emp
where E_comm=0;

select distinct length(E_name) as length_of_name from Hemu_emp;

select E_name,to_char(E_hiredate,'dd-mm-yy') from Hemu_emp
where E_dept=20;

select (current_date-E_hiredate)/30 as Number_of_months from Hemu_emp
where E_job='PRESIDENT';

select * from Hemu_emp
where extract(month from E_hiredate)=12;

select E_name,E_job,case
when E_job='CLERK' then '1'
when E_job='MANAGER' then '3'
when E_job='PRESIDENT' then '5'
ELSE 2
END AS 	Job_classification
from Hemu_emp;

select avg(E_sal) from Hemu_emp
group by E_job;

select count(E_sal) as E_sal_Count,(select count(E_comm) as E_comm_count from Hemu_emp
                    where E_comm>0 and E_dept=30) from Hemu_emp
where E_dept=30; 

update Hemu_emp
set E_comm=0
where E_comm is null;

select min(E_sal) as min_sal,max(E_sal) as max_sal,avg(E_sal) as avg_sal from Hemu_emp
group by E_job in('CLERK','MANAGER');

select E_dept 


