use mysql;
select host, user from user;
-- 因为mysql版本是5.7，因此新建用户为如下命令：
create user root identified by 'sandglassfinance_MySql_password+-';
-- 将sandglassfinance数据库的权限授权给创建的root用户，密码为sandglassfinance_MySql_password+-：
grant all on sandglassfinance.* to root@'%' identified by 'sandglassfinance_MySql_password+-' with grant option;
-- 这一条命令一定要有：
flush privileges;
