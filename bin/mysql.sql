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

CREATE TABLE `type`(
`id` int AUTO_INCREMENT NOT NULL,
`burma` int(5),
`cmee` int(5),
`cp` int(5),
`finance_id` int,
PRIMARY KEY(`id`),
FOREIGN KEY(`finance_id`) REFERENCES finance(`id`) ON DELETE CASCADE
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


--join finance and type table
select f.i_name, c.burma from finance f join chicken c join on f.i_name=c.burma where f.i_name=c.burma;

select f.id, c.id from finance f join chicken c on c.cmee=f.id;

select * from finance, chicken from finance f join chicken c on finance=chicken;

select * from finance f FULL JOIN chicken c on f.id=c.id;

--This is union join
SELECT * FROM finance LEFT JOIN chicken on finance.id = chicken.id UNION ALL SELECT * FROM finance RIGHT JOIN chicken on finance.id = chicken.id;

--This is inner join
SELECT i_date, i_name, burma, cmee, cp, rate, total, paid FROM finance INNER JOIN chicken ON finance.id = chicken.id;

