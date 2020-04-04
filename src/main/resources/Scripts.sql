CREATE TABLE `tb_student` (`id` int(11) NOT NULL AUTO_INCREMENT, `name` varchar(255) NOT NULL, `melicode` varchar(255) NOT NULL, PRIMARY KEY (`id`));
CREATE TABLE `tb_school` (`id` int(11) NOT NULL AUTO_INCREMENT, `name` varchar(255) NOT NULL, `address` varchar(255) NOT NULL, PRIMARY KEY (`id`));
CREATE TABLE `tb_link` (`id` int(11) NOT NULL AUTO_INCREMENT, `student_id` int(11) NOT NULL, `school_id` int(11) NOT NULL, PRIMARY KEY (`id`));


insert into `tb_student` (`id`, `name`, `melicode`) values('1','Afshin','1000');
insert into `tb_student` (`id`, `name`, `melicode`) values('2','Sadaf','1001');
insert into `tb_student` (`id`, `name`, `melicode`) values('3','Forough','1002');
insert into `tb_student` (`id`, `name`, `melicode`) values('4','Mahjoub','1003');

insert into `tb_school` (`id`, `name`, `address`) values('1','JavaShool','Tehran');
insert into `tb_school` (`id`, `name`, `address`) values('2','ReactShool','Qazvin');

insert into `tb_link` (`id`, `student_id`, `school_id`) values('1','1','1');
insert into `tb_link` (`id`, `student_id`, `school_id`) values('2','2','2');
insert into `tb_link` (`id`, `student_id`, `school_id`) values('3','3','2');
insert into `tb_link` (`id`, `student_id`, `school_id`) values('4','4','1');