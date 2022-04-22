create table sys_user_role (
    user_id bigint comment '用户ID',
    role_id bigint comment '角色ID'
);

alter table sys_user_role comment '用户角色关联表';