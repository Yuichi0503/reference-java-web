-- Project Name : noname
-- Date/Time    : 2024/06/06 14:26:07
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
CREATE TABLE users (
  user_id character varying(64) NOT NULL
  , user_name character varying(64) NOT NULL
  , email character varying(40) NOT NULL
  , hashed_password character varying(64) NOT NULL
  , salt character varying(32) NOT NULL
  , reg_date date DEFAULT now() NOT NULL
) ;

CREATE UNIQUE INDEX email_unique
  ON users(email);

COMMENT ON TABLE users IS 'users';
COMMENT ON COLUMN users.user_id IS 'user_id';
COMMENT ON COLUMN users.user_name IS 'user_name';
COMMENT ON COLUMN users.email IS 'email';
COMMENT ON COLUMN users.hashed_password IS 'hashed_password';
COMMENT ON COLUMN users.salt IS 'salt';
COMMENT ON COLUMN users.reg_date IS 'reg_date';

