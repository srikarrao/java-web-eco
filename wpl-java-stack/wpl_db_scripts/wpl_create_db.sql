/**
The script does the below:
1. Creating a schema for work permit lottery
2. granting read only privileges to the schema
Schema_Name: wpl_db
User_Name: wpluser
Password: wpldb01
**/
create database wpl_db;
use wpl_db;
grant all privileges on wpl_db.* to 'wpluser'@'%' identified by 'wpldb01';
