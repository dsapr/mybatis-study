create table sys_role_privilege (
    role_id      bigint comment '角色ID',
    privilege_id bigint comment '权限ID'
);

alter table sys_role_privilege comment '角色权限关联表';