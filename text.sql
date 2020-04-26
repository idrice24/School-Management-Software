CREATE  VIEW `login` AS 
select 
`newsms`.`users`.`id` AS `id`,
`newsms`.`users`.`password` AS `password`,
`newsms`.`users`.`email` AS `email` 
from `users`;

CREATE VIEW `studmarks` AS 
select 
marks.id as id,
marks.course AS course,
marks.level as level,
marks.score as score,
marks.matricule as matricule,
marks.studname as studname
from 
marks order by matricule ; 

CREATE VIEW studlist AS
SELECT 
student.id as id,
student.name as name,
 CONCAT (student.matricule,student.id,student.classe) as matricule,
student.gender as gender,
student.email as email,
student.school as school,
student.phone as phone,
student.address as address,
student.level as level,
student.classe as classe
from
student order by matricule;

create view teachlist as select 
	teacher.id as id,
	teacher.name as name,
	teacher.course as course,
	teacher.school as school,
	teacher.num as phone,
	teacher.email as email,
	CONCAT("CITA20",teacher.school, teacher.id) as matricule,
	teacher.address as address
	from teacher order by matricule;


SELECT column_name(s)
FROM table1
INNER JOIN table2
ON table1.column_name = table2.column_name;

SELECT column_name(s)
FROM table1
FULL OUTER JOIN table2
ON table1.column_name = table2.column_name
WHERE condition;

CREATE TABLE Orders (
    OrderID int NOT NULL,
    OrderNumber int NOT NULL,
    PersonID int,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)
);


SELECT CONCAT_WS('.', 'www', 'W3Schools', 'com');





CREATE VIEW `employee` As 
select 
worker.id As id,
worker.firstname As firstname,
worker.lastname As lastname,
worker.email As email,
worker.password As password,
worker.birthday As birthday,
worker.gender As gender,
worker.contact As contact,
worker.nid As nid,
worker.address As address,
worker.dept As dept,
worker.degree As degree,
worker.pic As pic,
worker.credate As create 
from worker order by id;


create view `salary` AS select 
salair.id as id,
salair.base as base,
salair.bonus as bonus,
salair.total as total
from salair order by id;


create view `project` as select 
work.pid as pid,
work.eid as eid,
work.pname as pname,
work.duedate as duedate,
work.subdate as subdate,
work.mark as mark,
work.status as status from 
work order by id;

create view `office` as select 
location.id as od,
location.city as city
from location order by id;


CREATE VIEW SWE1 AS
SELECT 
student.id as id,
student.name as name,
 CONCAT (student.matricule,student.id,student.classe) as matricule,
student.gender as gender,
student.email as email,
student.school as school,
student.phone as phone,
student.address as address,
student.level as level,
student.classe as classe,
teacher.name as Teach_Name,
teacher.matricule as teach_Id
from
student, teachlist where student.classe ="swe1" order by matricule;