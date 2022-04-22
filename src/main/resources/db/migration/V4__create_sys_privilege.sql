create table sys_privilege (
    id             bigint not null auto_increment comment '权限ID',
    privilege_name varchar(50)  comment '权限名称',
    privilege_url  varchar(200) comment '权限URL',
    primary key (id)
);

alter table sys_privilege comment '权限角色关联表';