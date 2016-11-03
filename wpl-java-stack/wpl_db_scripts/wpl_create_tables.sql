/**
Schema to create database tables
**/
CREATE TABLE application_details(
app_id INT NOT NULL AUTO_INCREMENT  comment 'application id',
ssn VARCHAR(9) NOT NULL,
employee_id VARCHAR(7) NOT NULL,
category VARCHAR(3) NOT NULL,
work_exp INT,
name VARCHAR(100),
age INT,
app_status VARCHAR(15),
applied_date DATE,PRIMARY KEY ( app_id,ssn,employee_id ))
ENGINE=InnoDB AUTO_INCREMENT=20000;

CREATE TABLE application_io_logging(
log_trans_id INT NOT NULL AUTO_INCREMENT,
source VARCHAR(15),
request_data LONGTEXT,
destination VARCHAR(15),
response_data LONGTEXT,
log_trans_date DATE,PRIMARY KEY (log_trans_id));