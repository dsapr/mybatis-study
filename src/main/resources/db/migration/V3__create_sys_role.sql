create table sys_role (
    id            bigint not null auto_increment comment '角色ID',
    role_name     varchar(50) comment '角色名',
    enabled       int         comment '有效标志',
    create_by     bigint      comment '创建人',
    create_time   datetime    comment '创建时间',
    primary key (id)
);

alter table sys_role comment '角色表';