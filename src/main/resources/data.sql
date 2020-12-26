DROP TABLE IF EXISTS tenant;

CREATE TABLE tenant (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  report_email_address VARCHAR(256) NOT NULL
);

INSERT INTO tenant (name, report_email_address) VALUES
  ('Ian', 'ianmattdavidson@gmail.com'),
  ('Tyler', 'dongloader@gmail.com');