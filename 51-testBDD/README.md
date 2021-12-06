create database baseTest;
use baseTest;
CREATE TABLE IF NOT EXISTS `tableTest` ( `ID` int(10) NOT NULL auto_increment, `nom` varchar(255), `tatoo` numeric(9,2), `naiss` date, `taille` decimal(9,2), PRIMARY KEY( `ID` ) );
insert into tableTest values ('1', 'Patrouille', '0125698', '2015-08-23', '50.4');
insert into tableTest values ('2', 'Maestro', '4589632', '2005-10-04', '32.4');
insert into tableTest values ('3', 'Fripouille', '9823345', '2008-12-31', '28.1');
select * from tableTest;

GRANT GRANT OPTION ON *.* TO 'adminrtlry'@'localhost';