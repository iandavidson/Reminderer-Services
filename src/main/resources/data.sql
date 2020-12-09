DROP TABLE IF EXISTS tenant;

CREATE TABLE tenant (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  report_email_address VARCHAR(256) NOT NULL,
  phone_number VARCHAR(256) DEFAULT NULL
);

INSERT INTO billionaires (name, report_email, phone_number) VALUES
  ('Ian', 'ianmattdavidson@gmail.com', '1800777777');