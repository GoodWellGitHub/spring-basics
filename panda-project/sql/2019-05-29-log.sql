create table app_log(
id int(11) not null AUTO_INCREMENT comment '主键ID',
app_name varchar(36) not null default '' comment '所属应用',
log_type int (11) not null default 0 comment '日志类型，0为操作日志，1为异常日志',
user varchar(100) not null default '' comment '访问者/请求者',
method_name varchar(200) not null default '' comment '方法名',
request_params varchar (500) not null default '' comment '请求参数',
method_description varchar(100) not null default '' comment '方法描述',
request_ip varchar(50) not null default '' comment '访问者IP',
request_url varchar (200) not null default '' comment '请求URI',
request_path varchar (200) not null default '' comment '请求PATH',
exception_code varchar (100) not null default '' comment '异常码',
exception_detail varchar (100) not null default '' comment '异常描述',
status varchar (200) not null default '' comment '请求返回状态',
content text comment '请求返回内容',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,
primary key (id)
);