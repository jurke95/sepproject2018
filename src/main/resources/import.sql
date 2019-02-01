INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('1', 'Chemistry');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('2', 'Physics');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('3', 'Geology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('4', 'Biology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('5', 'Zoology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('6', 'Mathematics');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('7', 'Technology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('8', 'Economy');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`coauthors`,`abstractt`,`pdf`,`version`) VALUES ('1', 'Chemical essay','ww','abs','pdf','1.0');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`coauthors`,`abstractt`,`pdf`,`version`) VALUES ('2', 'Science laws','ww','abs','pdf','1.0');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`coauthors`,`abstractt`,`pdf`,`version`) VALUES ('3', 'Maths operations','ww','abs','pdf','1.0');
INSERT INTO `sepback`.`editor` (`id`,`name`,`surname`,`city`,`country`,`title`,`password`,`username`,`active`,`is_recensent`,`email`) VALUES ('1', 'Marko','Juric','Novi Sad','Serbia','dipl.ing','$2a$04$L4Odkksvb3Eqd0iC7e/59eshJ86r9KC4WY3hACUzyWbnk.65qqp/S','jurke95',true,false,'markivicius@hotmail.com')
INSERT INTO `sepback`.`reg_user` (`id`,`password`,`username`,`email`,`active`,`name`,`surname`,`city`,`country`,`title`) VALUES ('1', '$2a$04$L4Odkksvb3Eqd0iC7e/59eshJ86r9KC4WY3hACUzyWbnk.65qqp/S','jurke95','markivicius@hotmail.com',true, 'Marko','Juric','Novi Sad','Serbia','dipl.ing')
INSERT INTO `sepback`.`editor_area` (`editor_id`,`sarea_id`) VALUES ('1', '6');
INSERT INTO `sepback`.`editor_area` (`editor_id`,`sarea_id`) VALUES ('1', '2');
INSERT INTO `sepback`.`editor_area` (`editor_id`,`sarea_id`) VALUES ('1', '8');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`,`imgpath`) VALUES ('1', 'Bankarstvo','1264-4556','bankarstvo.jpg');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`,`imgpath`) VALUES ('2', 'Tehnika','3896-5485','tehnika.jpg');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`,`imgpath`) VALUES ('3', 'Zaštita prirode','4564-1545','zastitaprirode.jpg');


