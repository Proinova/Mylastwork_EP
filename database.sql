DROP DATABASE IF EXISTS spain;
CREATE DATABASE spain;
USE spain;
CREATE TABLE potrebiteli(
 id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(255),
 pass VARCHAR(255),
 mail VARCHAR(255)
);
INSERT INTO potrebiteli VALUES
 (1,"admin","admin","admin@local.bg");