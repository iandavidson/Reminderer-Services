DROP TABLE IF EXISTS tenant;

CREATE TABLE tenant (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  report_email_address VARCHAR(256) NOT NULL
);

INSERT INTO tenant (name, report_email_address) VALUES
  ('Ian', 'ianmattdavidson@gmail.com'),
  ('Tyler', 'awesomeExample@gmail.com');


DROP TABLE IF EXISTS schedule_descriptor;

  
CREATE TABLE `schedule_descriptor` (
  id int unsigned NOT NULL AUTO_INCREMENT,
  schedule varchar(64) NOT NULL DEFAULT '',
  tenant_id bigint(20) unsigned NOT NULL,
  creation_date timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Schedule_Descriptor_fk` (`tenant_id`),
  CONSTRAINT `Scan_Schedule_Descriptor_fk` FOREIGN KEY (`tenant_id`) REFERENCES `tenant` (`id`) ON DELETE CASCADE
);

INSERT INTO schedule_descriptor (schedule, tenant_id) VALUES
  ('0 */3 * * * *', 1),
  ('0 1 11 ? * *', 2);
 


