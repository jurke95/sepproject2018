
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('1', 'Chemistry');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('2', 'Physics');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('3', 'Geology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('4', 'Biology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('5', 'Zoology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('6', 'Mathematics');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('7', 'Technology');
INSERT INTO `sepback`.`science_area` (`id`,`name`) VALUES ('8', 'Economy');
INSERT INTO `sepback`.`editor` (`id`,`name`,`surname`,`city`,`country`,`title`,`password`,`username`,`active`,`is_recensent`,`email`) VALUES ('1', 'Marko','Juric','Novi Sad','Serbia','dipl.ing','$2a$04$L4Odkksvb3Eqd0iC7e/59eshJ86r9KC4WY3hACUzyWbnk.65qqp/S','jurke95',true,false,'markojuric@hotmail.com')
INSERT INTO `sepback`.`author` (`id`,`name`,`surname`,`city`,`country`,`password`,`username`,`active`,`email`) VALUES ('1', 'Dragan','Dulic','Novi Sad','Serbia','$2a$10$qeJxoyN50X/5KZKQn6XEg.cXR0MDjNIFx73zAOjdjaxj2aAfqkuHK','dulke',true,'dragandulic@hotmail.com')
INSERT INTO `sepback`.`reader` (`id`,`name`,`surname`,`city`,`country`,`password`,`username`,`active`,`email`) VALUES ('1', 'Saska','Grujic','Novi Sad','Serbia','$2a$10$pDS1YzlQweYr3rVsfLMMjOyf7u77SKyGGP28XYR936jU6gSn9Te.S','saska95',true,'saskagrujic@hotmail.com')
INSERT INTO `sepback`.`reg_user` (`id`,`password`,`username`,`email`,`active`,`name`,`surname`,`city`,`country`,`title`,`role`) VALUES ('1', '$2a$04$L4Odkksvb3Eqd0iC7e/59eshJ86r9KC4WY3hACUzyWbnk.65qqp/S','jurke95','markojuric@hotmail.com',true, 'Marko','Juric','Novi Sad','Serbia','dipl.ing','USER')
INSERT INTO `sepback`.`reg_user` (`id`,`password`,`username`,`email`,`active`,`name`,`surname`,`city`,`country`,`role`) VALUES ('2', '$2a$10$qeJxoyN50X/5KZKQn6XEg.cXR0MDjNIFx73zAOjdjaxj2aAfqkuHK','dulke','dragandulic@hotmail.com',true, 'Dragan','Dulic','Novi Sad','Serbia','AUTHOR')
INSERT INTO `sepback`.`reg_user` (`id`,`password`,`username`,`email`,`active`,`name`,`surname`,`city`,`country`,`role`) VALUES ('3', '$2a$10$pDS1YzlQweYr3rVsfLMMjOyf7u77SKyGGP28XYR936jU6gSn9Te.S','saska95','saskagrujic@hotmail.com',true, 'Saska','Grujic','Novi Sad','Serbia','USER')
INSERT INTO `sepback`.`reg_user` (`id`,`password`,`username`,`email`,`active`,`name`,`surname`,`city`,`country`,`role`) VALUES ('4', '$2a$04$L4Odkksvb3Eqd0iC7e/59eshJ86r9KC4WY3hACUzyWbnk.65qqp/S','nena95','nevena.sumar@gmail.com',true, 'Nevena','Sumar','Novi Sad','Serbia','EDITOR')
INSERT INTO `sepback`.`editor_area` (`editor_id`,`sarea_id`) VALUES ('1', '6');
INSERT INTO `sepback`.`editor_area` (`editor_id`,`sarea_id`) VALUES ('1', '2');
INSERT INTO `sepback`.`editor_area` (`editor_id`,`sarea_id`) VALUES ('1', '8');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`,`imgpath`,`membershipfee`,`client_id`,`client_secret`,`openaccess`,`bitcointoken`,`merchant_id`,`merchant_password`,`maineditor_id`) VALUES ('1', 'Bankarstvo','1264-4556','bankarstvo.jpg','30','ARaJUwD8O9-cjYkit1QgALKUsO3CdX9Bl_eUA6-rsINvxI-IVFeolaSQqSs8ZUEad3D5AGNmY491zGKd','EAvfBEVBG3lushFJX_oPbgn4kmg-9qxwBPLV9f_Dhda6oWCd864DVh-u7qjlB-IF2Jr2ln-jnD9fSX-Y',false,'mPm_rJqA3rE2xTmzP-Jym-ijeGuxzqqHg8stXH62','411sldmcv81yt6j5nf9q2nv0m4u7v9','2','4');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`,`imgpath`,`membershipfee`,`client_id`,`client_secret`,`openaccess`,`bitcointoken`,`merchant_id`,`merchant_password`,`maineditor_id`) VALUES ('2', 'Tehnika','3896-5485','tehnika.jpg','28','Ae_veWhOruZQCZjrHCUBECmnkXvoEhO_vhIZGCkglx1qvqyGkI22FQVRxtfaeJP1CTL2NZMQJZZHyhXc','EJV26g8cD_0Fl4cCafn17KSp8eDuJEVvVEz_PM3IRSzvh64M-pCqAsz3fx_zraNNL5xTI6q0-kTNJ2HO',true,'54Ch5HzaV_iCoUvFsru9QEpZC8QA_fpQFgWLZy99','977dk4mdjw3bz82hd71abgm39dm48f','1','4');
INSERT INTO `sepback`.`magazine` (`id`,`name`,`issn`,`imgpath`,`membershipfee`,`client_id`,`client_secret`,`openaccess`,`bitcointoken`,`merchant_id`,`merchant_password`,`maineditor_id`) VALUES ('3', 'Zastita prirode','4564-1545','zastitaprirode.jpg','25','AUTAPxDywfXhkA_1NaZkPoAlRWrjGGlBDnmJSLk3BopA1amVYYTWap7ITfdKeaVzceOZIDQDDSTUnER7','ECMSo13_1Yw7J2eL6mNVDIqPV2KKDEJ8QZ6wOVRfZ6gcx_54GnO6cWU-na4G0IYOFbwaePY_vPtXKeFI',false,'izexwAgSRxcvWSoWHESxq1QSe8zkv_BztYBJSZYc','411qazswedc345rfghtrdbn789iklj','zastitasep','4');
INSERT INTO `sepback`.`magazine_edition` (`id`,`magazine_id`,`number`,`name`,`pdf`,`price`) VALUES ('1', '1','1','Bankarstvo Broj 1','Bankarstvo1.pdf','5');
INSERT INTO `sepback`.`magazine_edition` (`id`,`magazine_id`,`number`,`name`,`pdf`,`price`) VALUES ('2', '1','2','Bankarstvo Broj 2','Bankarstvo2.pdf','5');
INSERT INTO `sepback`.`magazine_edition` (`id`,`magazine_id`,`number`,`name`,`pdf`,`price`) VALUES ('3', '1','3','Bankarstvo Broj 3','Bankarstvo3.pdf','5');
INSERT INTO `sepback`.`magazine_edition` (`id`,`magazine_id`,`number`,`name`,`pdf`,`price`) VALUES ('4', '2','1','Tehnika Broj 1','Tehnika1.pdf','5');
INSERT INTO `sepback`.`magazine_edition` (`id`,`magazine_id`,`number`,`name`,`pdf`,`price`) VALUES ('5', '3','1','Zastita prirode Broj 1','Zastita1.pdf','5');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('1','1.Prometna banka A.D. u modernizacijskim procesima u Srbiji u prvoj polovini XX veka','1.Prometna banka A.D. u modernizacijskim procesima u Srbiji u prvoj polovini XX veka.pdf','1','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('2','2.Trenutni prioritet Bazelskog komiteta-podizanje letvice','2.Trenutni priorotet Bazelskog komiteta-podizanje letvice.pdf','1','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('3','3.Kreditni rizik i kreditni derivati','3.Kreditni rizik i kreditni derivati.pdf','1','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('4','4.Nestandardne mere monetarne politike','4.Nestandardne mere monetarne politike.pdf','1','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('5','1.Ekonomika Bokeljske mornarice','1.Ekonomika Bokeljske mornarice.pdf','1','2');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('6','2.Sustina i aktuelnost Mandel-Flemingovog modela','2.Sustina i aktuelnost Mandel-Flemingovog modela.pdf','1','2');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('7','3.Razvojni putevi bankarstva u Velikoj Britaniji i Irskoj','3.Razvojni putevi bankarstva u Velikoj Britaniji i Irskoj.pdf','1','2');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('8','4.Velikan ekonomske misli XX veka','4.Velikan ekonomske misli XX veka.pdf','1','2');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('9','1.Bazel III -Medjunarodni okvir za merenje izlozenosti riziku likvidnosti','1.Bazel III -Medjunarodni okvir za merenje izlozenosti riziku likvidnosti.pdf','1','3');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('10','2.Uticaj trgovinskih i bankarskih kredita na svetski izvoz','2.Uticaj trgovinskih i bankarskih kredita na svetski izvoz.pdf','1','3');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('11','3.Pregled jednofaktorskih modela kamatnih stopa sa fokusom na model Hal i Vajt','3.Pregled jednofaktorskih modela kamatnih stopa sa fokusom na model Hal i Vajt.pdf','1','3');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('12','4.Ekonomija je umetnost zivljenja','4.Ekonomija je umetnost zivljenja.pdf','1','3');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('13','1.Sinteza i opticke karakteristike nanostrukturnih prahovaZnO i ZnOPEO','1.Sinteza i opticke karakteristike nanostrukturnih prahovaZnO i ZnOPEO.pdf','2','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('14','2.Tehnologije proizvodnje vodonika koriscenjem solarne energije','2.Tehnologije proizvodnje vodonika koriscenjem solarne energije.pdf','2','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('15','3.Kontrola temperature uljnih transformatora promenom brzine obrtaja ventilatora','3.Kontrola temperature uljnih transformatora promenom brzine obrtaja ventilatora.pdf','2','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('16','4.Metodologija procenje potrosnje energije u saobracaju koriscenjem transportnog modela grada','4.Metodologija procenje potrosnje energije u saobracaju koriscenjem transportnog modela grada.pdf','2','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('17','1.Floristicke karakteristike Sarplaninskog grebena kobilica','1.Floristicke karakteristike Sarplaninskog grebena kobilica.pdf','3','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('18','2.Preliminaran opis novog roda ISOPHYA iz Srbije','2.Preliminaran opis novog roda ISOPHYA iz Srbije.pdf','3','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('19','3.Foleofilne vrste roda Onthophagus u fauni Srbije','3.Foleofilne vrste roda Onthophagus u fauni Srbije.pdf','3','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('20','4.Prilog poznavanju stenica Vlasine','4.Prilog poznavanju stenica Vlasine.pdf','3','1');
INSERT INTO `sepback`.`scientific_work` (`id`,`name`,`pdf`,`magazine_id`,`edition_id`) VALUES ('21','5.Nalaz leventskog sivog dugousana na podrucju poseda manastira Hilandara','5.Nalaz leventskog sivog dugousana na podrucju poseda manastira Hilandara.pdf','3','1');











