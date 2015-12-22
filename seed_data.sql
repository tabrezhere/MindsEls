INSERT INTO `mindsels_online`.`context`(`id`,`context`) VALUES (1,'sys_admin');
INSERT INTO `mindsels_online`.`context`(`id`,`context`) VALUES (2,'org_admin');
INSERT INTO `mindsels_online`.`context`(`id`,`context`) VALUES (3,'campus_admin');
INSERT INTO `mindsels_online`.`context`(`id`,`context`) VALUES (4,'student');
INSERT INTO `mindsels_online`.`context`(`id`,`context`) VALUES (5,'staff');
INSERT INTO `mindsels_online`.`context`(`id`,`context`) VALUES (6,'parent/guardian');
INSERT INTO `mindsels_online`.`context`(`id`,`context`) VALUES (7,'publisher');
INSERT INTO `mindsels_online`.`context`(`id`,`context`) VALUES (8,'librarian');


INSERT INTO `mindsels_online`.`user`
(`id`,`Firstname`,`MiddleName`,`Lastname`,`password`,`Address1`,`Address2`,`City`,`State`,`Createat`,`Updatedat`,`Deleted`,`hasher`,`salt`)
VALUES (1,'Mohd','ilyas','siddiqui','$2a$10$h1JZbMovocR1jVzDLEFSFuqr2olut08NvQZhmqx3BZEu7a7NBXBUq','colony','Masjid road','Gulbarga','Karnataka','2015-03-10 21:22:58',
'2015-03-10 21:22:58',1,'bcrypt',null);


INSERT INTO `mindsels_online`.`organization`(`id`,`name`,`activated`,`paid`,`deleted`) VALUES (1,'faraan',1,1,0);


INSERT INTO `mindsels_online`.`campus`(`id`,`campus_name`,`organization_id`) VALUES (1,'Faraan High School',1);


INSERT INTO `mindsels_online`.`user_context`(`id`,`user_id`,`context_id`,`campus_id`) VALUES (1,1,2,1);

INSERT INTO `mindsels_online`.`user_login`(`id`,`email_id`,`phone_number`,`verified`,`user_id`) VALUES
(1,'user1',7406367713,1,1);











