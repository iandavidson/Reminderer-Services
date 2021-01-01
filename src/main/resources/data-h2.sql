
INSERT INTO tenant (name, report_email_address) VALUES
  ('Ian', 'ianmattdavidson@gmail.com'),
  ('Tyler', 'awesomeExample@gmail.com');


INSERT INTO schedule_descriptor (schedule, reminder, tenant_id) VALUES
  ('0 */3 * * * *', 'Wow neato', 1),
  ('0 1 11 ? * *', 'Good job sport!', 2);
 


