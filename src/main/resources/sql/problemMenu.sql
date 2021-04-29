-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('问题管理', '2000', '1', 'problem', 'project/problem/index', 1, 0, 'C', '0', '0',
        'project:problem:list', '#', 'admin', sysdate(), '', null, '问题管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('问题管理查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'project:problem:query',
        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('问题管理新增', @parentId, '2', '#', '', 1, 0, 'F', '0', '0', 'project:problem:add',
        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('问题管理修改', @parentId, '3', '#', '', 1, 0, 'F', '0', '0', 'project:problem:edit',
        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('问题管理删除', @parentId, '4', '#', '', 1, 0, 'F', '0', '0', 'project:problem:remove',
        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('问题管理导出', @parentId, '5', '#', '', 1, 0, 'F', '0', '0', 'project:problem:export',
        '#', 'admin', sysdate(), '', null, '');