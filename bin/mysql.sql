select * from finance;

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


--join finance and type table
select f.i_name, t.burma from finance f join type t on t.burma=f.i_name;

