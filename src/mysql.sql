select * from finance;

select * from chicken;

CREATE TABLE `finance`(
`id` int AUTO_INCREMENT NOT NULL,
`i_date` date NOT NULL,
`i_name` varchar(30) NOT NULL,
`rate` int NOT NULL,
`total` int NOT NULL,
`paid` int NOT NULL,
PRIMARY KEY(`id`)
);


CREATE TABLE `chicken`(
`id` int AUTO_INCREMENT NOT NULL,
`burma` int(5),
`cmee` int(5),
`cp` int(5),
`finance_id` int,
PRIMARY KEY(`id`),
FOREIGN KEY(`finance_id`) REFERENCES finance(`id`) ON DELETE CASCADE
);

insert into chicken (burma, cmee, cp, finance_id) values (2,3,4,5);

--This is union join
SELECT * FROM finance LEFT JOIN chicken on finance.id = chicken.id UNION ALL SELECT * FROM finance RIGHT JOIN chicken on finance.id = chicken.id;

--This is inner join
SELECT finance.id AS id, i_date, i_name, burma, cmee, cp, rate, total, paid FROM finance INNER JOIN chicken ON finance.id = chicken.id;

--delete
DELETE FROM finance WHERE id = 11;

drop table finance;
drop table chicken;

--to fix mysql foreign key error
SET FOREIGN_KEY_CHECKS=1;
SET GLOBAL FOREIGN_KEY_CHECKS=0;

SHOW GLOBAL VARIABLES LIKE 'FOREIGN_KEY_CHECKS';