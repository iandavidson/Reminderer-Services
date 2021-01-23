DROP TABLE IF EXISTS tenant;

CREATE TABLE tenant (
  id bigint(20) unsigned not null AUTO_INCREMENT,
  name VARCHAR(250) NOT NULL,
  report_email_address VARCHAR(256) NOT NULL,
  primary key (id)
);

DROP TABLE IF EXISTS scheduleDescriptor;

  
CREATE TABLE `schedule_descriptor` (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  schedule varchar(64) NOT NULL DEFAULT '',
  reminder varchar(256) NOT NULL DEFAULT '',
  tenant_id bigint(20) unsigned NOT NULL,
  creation_date timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Schedule_Descriptor_fk` (`tenant_id`),
  CONSTRAINT `Scan_Schedule_Descriptor_fk` FOREIGN KEY (`tenant_id`) REFERENCES `tenant` (`id`) ON DELETE CASCADE
);


