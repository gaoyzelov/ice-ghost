-- 用户表
create table if not exists sys_user(
    id integer not null primary key autoincrement ,
    username text not null ,
    password text not null ,
    create_by text not null default 'system',
    create_time text not null default current_timestamp,
    update_by text,
    update_time text
);