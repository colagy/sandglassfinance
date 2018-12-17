
-- 开发者账号

set @uid=replace(uuid(),'-','');
insert into user (id,type) values(@uid,'dev');
insert into user_dev (id,uid,username,password) values(replace(uuid(),'-',''),@uid,'colagy','674587f3f91f7a3be7dd0af0d26dde0176097b8c');

-- 账户类型

insert into account_type (id,type,name,classify) values(replace(uuid(),'-',''),'cash','现金',0);
insert into account_type (id,type,name,classify) values(replace(uuid(),'-',''),'wechat','微信',0);
insert into account_type (id,type,name,classify) values(replace(uuid(),'-',''),'alipay','支付宝',0);
insert into account_type (id,type,name,classify) values(replace(uuid(),'-',''),'bank','银行卡',0);
insert into account_type (id,type,name,classify) values(replace(uuid(),'-',''),'default','未选账户',0);

