INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('1', 'Chemistry');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('2', 'Physics');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('3', 'Geology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('4', 'Biology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('5', 'Zoology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('6', 'Mathematics');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('7', 'Statistics');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('8', 'Logic');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`coauthors`,`abstractt`,`pdf`,`version`) VALUES ('1', 'Chemical essay','ww','abs','pdf','1.0');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`coauthors`,`abstractt`,`pdf`,`version`) VALUES ('2', 'Science laws','ww','abs','pdf','1.0');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`coauthors`,`abstractt`,`pdf`,`version`) VALUES ('3', 'Maths operations','ww','abs','pdf','1.0');
INSERT INTO `sepback`.`editor` (`id`,`name`,`surname`,`city`,`country`,`title`,`password`,`username`,`active`,`is_recensent`,`email`) VALUES ('1', 'Marko','Juric','Novi Sad','Serbia','dipl.ing','$2a$04$L4Odkksvb3Eqd0iC7e/59eshJ86r9KC4WY3hACUzyWbnk.65qqp/S','jurke95',true,false,'markivicius@hotmail.com')
INSERT INTO `sepback`.`reg_user` (`id`,`password`,`username`,`email`,`active`,`name`,`surname`,`city`,`country`,`title`) VALUES ('1', '$2a$04$L4Odkksvb3Eqd0iC7e/59eshJ86r9KC4WY3hACUzyWbnk.65qqp/S','jurke95','markivicius@hotmail.com',true, 'Marko','Juric','Novi Sad','Serbia','dipl.ing')
INSERT INTO `sepback`.`editor_area` (`editor_id`,`sarea_id`) VALUES ('1', '6');
INSERT INTO `sepback`.`editor_area` (`editor_id`,`sarea_id`) VALUES ('1', '2');
INSERT INTO `sepback`.`editor_area` (`editor_id`,`sarea_id`) VALUES ('1', '8');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`) VALUES ('1', 'All about Space','1264-4556');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`) VALUES ('2', 'Laboratory news','3896-5485');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`) VALUES ('3', 'Euro Scientist','4564-1545');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`) VALUES ('4', 'Sci Tech','7823-2342');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`) VALUES ('5', 'Kvant','7213-6546');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`) VALUES ('6', 'Popular Mechanics','5214-1546');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`) VALUES ('7', 'Nautilus','5798-5932');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`) VALUES ('8', 'BBC Knowledge','2332-3333');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`) VALUES ('9', 'Planetary Report','7418-9632');

