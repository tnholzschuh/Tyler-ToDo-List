CREATE DATABASE tyler_todo_list;

--DROP TABLE IF EXISTS user_auth;
--CREATE TABLE user_auth (
--  user_id BIGINT PRIMARY KEY NOT NULL,
--  username VARCHAR(50) UNIQUE NOT NULL,
--  password VARCHAR(68) NOT NUlL
--)
--
--DROP TABLE IF EXISTS user_role;
--CREATE TABLE

DROP TABLE IF EXISTS todo_item;
CREATE TABLE todo_item (
  id SERIAL PRIMARY KEY NOT NULL,
  todo_item VARCHAR(200),
  username VARCHAR(200)
--  FOREIGN KEY (user_id) REFERENCES user_auth(user_id)
);
