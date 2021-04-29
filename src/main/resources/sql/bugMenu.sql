-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('缺陷', '2000', '1', 'bug', 'project/bug/index', 1, 0, 'C', '0', '0',
        'project:bug:list', '#', 'admin', sysdate(), '', null, '缺陷菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('缺陷查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'project:bug:query', '#',
        'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('缺陷新增', @parentId, '2', '#', '', 1, 0, 'F', '0', '0', 'project:bug:add', '#',
        'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('缺陷修改', @parentId, '3', '#', '', 1, 0, 'F', '0', '0', 'project:bug:edit', '#',
        'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('缺陷删除', @parentId, '4', '#', '', 1, 0, 'F', '0', '0', 'project:bug:remove', '#',
        'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('缺陷导出', @parentId, '5', '#', '', 1, 0, 'F', '0', '0', 'project:bug:export', '#',
        'admin', sysdate(), '', null, '');