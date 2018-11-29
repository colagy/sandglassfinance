-- 数据库设计原则
-- 1.禁止使用外键 表关系由程序逻辑控制

-- 创建数据库
create database if not exists `sandglassfinance` default character set utf8mb4 collate utf8mb4_general_ci;
 
use sandglassfinance;

-- 设置数据库

show variables like '%char%';
set character_set_client=`utf8mb4`;
set character_set_connection=`utf8mb4`;
set character_set_results=`utf8mb4`;
set character_set_server=`utf8mb4`;
set character_set_database=`utf8mb4`;

-- 设置时区

set time_zone = `+8:00`;

-- 创建表

CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `type` int(2) NOT NULL comment '账户类型 0,微信开放平台 1,蚂蚁金服开放平台',
  `user_id` varchar(50) NOT NULL comment '微信开放平台用户id 蚂蚁金服开放平台id',
  `openid` varchar(50) DEFAULT "" comment '微信用户id',
  `session_key` varchar(50) DEFAULT "" comment '微信小程序会话密钥',
  `access_token` varchar(200) DEFAULT "" comment '令牌',
  `expires_in` varchar(10) DEFAULT "" comment '有效期',
  `refresh_token` varchar(200) DEFAULT "" comment '刷新令牌',
  `scope` varchar(50) DEFAULT "" comment '作用域',
  `create_at` varchar(20) DEFAULT "" comment '令牌建立时间',
  `deleted` int(1) DEFAULT 0,
  primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment='用户表';

CREATE TABLE `accountbook` (
 `id` varchar(36) NOT NULL,
 `name` varchar(255) NOT NULL comment '账本名称',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '用户账本表';

CREATE TABLE `user_info` (
 `id` varchar(36) NOT NULL,
 `user_id` varchar(36) NOT NULL comment '用户id',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '用户信息表';

CREATE TABLE `account_type` (
 `id` varchar(36) NOT NULL,
 `type` varchar(255) NOT NULL comment '类型 cash,现金 wechat,微信 alipay,支付宝 bank,银行卡 investment,投资(基金/股票/定期/保险) default,未选账户',
 `name` varchar(255) NOT NULL comment '类型名',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '账户类型表';

CREATE TABLE `account` (
 `id` varchar(36) NOT NULL,
 `account_type_id` varchar(36) NOT NULL comment '账户类型',
 `balance` double(20,2) DEFAULT 0 comment '余额',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '账户表';

CREATE TABLE `accountbook_account` (
 `id` varchar(36) NOT NULL,
 `accountbook_id` varchar(36) NOT NULL comment '账本id',
 `account_id` varchar(36) NOT NULL comment '账户id',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '账本账户表';

CREATE TABLE `revenue_type` (
 `id` varchar(36) NOT NULL,
 `type` varchar(255) NOT NULL comment '类型 wages,工资 capital,奖金 business_income,营业收入 bonus,红利(股息,投资回报) living_expenses,生活费 reimbursement,报销 loan,借入款 cash_gift,礼金 other,其他',
 `name` varchar(255) NOT NULL comment '类型名',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '收入类型表';

CREATE TABLE `custom_revenue_type` (
 `id` varchar(36) NOT NULL,
 `user_id` varchar(36) NOT NULL comment '用户id',
 `name` varchar(255) NOT NULL comment '类型名',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '用户自定义收入类型表';

CREATE TABLE `account_revenue` (
 `id` varchar(36) NOT NULL,
 `account_id` varchar(36) NOT NULL comment '账户id',
 `default_revenue_type` int(2) NOT NULL comment '收入类型 0,默认类型 1,自定义类型',
 `revenue_type_id` varchar(36) NOT NULL comment '收入类型id',
 `time` datetime NOT NULL comment '时间',
 `amount` double(20,2) NOT NULL comment '金额',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '账户收入表';

CREATE TABLE `expenditure_type` (
 `id` varchar(36) NOT NULL,
 `type` varchar(255) NOT NULL comment '类型 dietary_consume,饮食 shopping,购物 traffic,交通 study,学习 cash_gift,礼金 nntertainment_expenditure,娱乐 consum_of_daily_necessities,日用 medical_expenses,医疗 housing_loan,房贷 car_loan,车贷 credit_card_repayment,信用卡还款 app_repayment,app还款 instalments,分期付款 other_repayment,其他还款 other,其他支出',
 `name` varchar(255) NOT NULL comment '类型名',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '支出类型表';

CREATE TABLE `custom_expenditure_type` (
 `id` varchar(36) NOT NULL,
 `user_id` varchar(36) NOT NULL comment '用户id',
 `name` varchar(255) NOT NULL comment '类型名',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '自定义支出类型表';

CREATE TABLE `account_expenditure` (
 `id` varchar(36) NOT NULL,
 `account_id` varchar(36) NOT NULL comment '账户id',
 `default_expenditure_type` int(2) NOT NULL comment '支出类型 0,默认类型 1,自定义类型',
 `expenditure_type_id` varchar(36) NOT NULL comment '支出类型id',
 `time` datetime NOT NULL comment '时间',
 `amount` double(20,2) NOT NULL comment '金额',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '账户支出表';

CREATE TABLE `account_fixed_revenue` (
 `id` varchar(36) NOT NULL,
 `account_id` varchar(36) NOT NULL comment '账户id',
 `default_fixed_revenue_type` int(2) NOT NULL comment '收入类型 0,默认类型 1,自定义类型',
 `fixed_revenue_type_id` varchar(36) NOT NULL comment '收入类型id',
 `time_unit` varchar(255) NOT NULL comment '时间单位 year,年 quarter,季度 month,月 week,周 day,日',
 `month` varchar(255) DEFAULT NULL comment '月',
 `day` varchar(255) DEFAULT NULL comment '日',
 `week` varchar(255) DEFAULT NULL comment '周 0,周日 1,周一 2,周二 3,周三 4,周四 5,周五 6,周六',
 `start_time` datetime DEFAULT NULL comment '开始时间',
 `end_time` datetime DEFAULT NULL comment '结束时间 最长5年',
 `amount` double(20,2) NOT NULL comment '金额',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '账户固定收入表';

CREATE TABLE `account_fixed_expenditure` (
 `id` varchar(36) NOT NULL,
 `account_id` varchar(36) NOT NULL comment '账户id',
 `default_fixed_expenditure_type` int(2) NOT NULL comment '支出类型 0,默认类型 1,自定义类型',
 `fixed_expenditure_type_id` varchar(36) NOT NULL comment '支出类型id',
 `time_unit` varchar(255) NOT NULL comment '时间单位 year,年 quarter,季度 month,月 week,周 day,日',
 `month` varchar(255) DEFAULT NULL comment '月',
 `day` varchar(255) DEFAULT NULL comment '日',
 `week` varchar(255) DEFAULT NULL comment '周 0,周日 1,周一 2,周二 3,周三 4,周四 5,周五 6,周六',
 `start_time` datetime DEFAULT NULL comment '开始时间',
 `end_time` datetime DEFAULT NULL comment '结束时间 最长5年',
 `amount` double(20,2) NOT NULL comment '金额',
 `mark` varchar(255) DEFAULT '' comment '备注',
 `deleted` int(1) DEFAULT 0,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '账户固定支出表';

-- 用户表
-- 用户信息表
-- 账户表
-- 账本表
-- 收入类型表
-- 自定义收入类型表
-- 账户收入表
-- 账户固定收入表
-- 账户应收款表
-- 支出类型表
-- 自定义支出类型表
-- 支出表
-- 账户支出表
-- 账户固定支出表
-- 账户应付款表
-- 资产表
-- 负债表
