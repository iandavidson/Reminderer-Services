
INSERT INTO tenant (name, report_email_address) VALUES
  ('Ian', 'ianmattdavidson@gmail.com'),
  ('Tyler', 'awesomeExample@gmail.com');


INSERT INTO schedule_descriptor (schedule, tenant_id) VALUES
  ('0 */3 * * * *', 1),
  ('0 1 11 ? * *', 2);
 


