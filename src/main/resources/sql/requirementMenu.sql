-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('需求管理', '2000', '1', 'requirement', 'project/requirement/index', 1, 0, 'C', '0',
        '0', 'project:requirement:list', '#', 'admin', sysdate(), '', null, '需求菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('需求查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'project:requirement:query',
        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('需求新增', @parentId, '2', '#', '', 1, 0, 'F', '0', '0', 'project:requirement:add',
        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('需求修改', @parentId, '3', '#', '', 1, 0, 'F', '0', '0', 'project:requirement:edit',
        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('需求删除', @parentId, '4', '#', '', 1, 0, 'F', '0', '0',
        'project:requirement:remove', '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame,
                      is_cache, menu_type, visible, status, perms, icon, create_by,
                      create_time, update_by, update_time, remark)
values ('需求导出', @parentId, '5', '#', '', 1, 0, 'F', '0', '0',
        'project:requirement:export', '#', 'admin', sysdate(), '', null, '');