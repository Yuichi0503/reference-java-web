-- Project Name : noname
-- Date/Time    : 2024/06/07 16:01:51
-- Author       : kunre
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  << 注意！！ >>
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
  この機能は A5:SQL Mk-2でのみ有効であることに注意してください。
*/

-- users
-- * RestoreFromTempTable
create table users (
  user_id character varying(64) not null
  , user_name character varying(64) not null
  , email character varying(40) not null
  , hashed_password character varying(64) not null
  , salt character varying(32) not null
  , reg_date date default now() not null
  , token character varying(255)
  , is_verified boolean default false
) ;

create unique index email_unique
  on users(email);

comment on table users is 'users';
comment on column users.user_id is 'user_id';
comment on column users.user_name is 'user_name';
comment on column users.email is 'email';
comment on column users.hashed_password is 'hashed_password';
comment on column users.salt is 'salt';
comment on column users.reg_date is 'reg_date';
comment on column users.token is 'token';
comment on column users.is_verified is 'is_verified';

