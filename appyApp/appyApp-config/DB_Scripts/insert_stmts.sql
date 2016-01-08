-- sample insert statements

-- ROLE table. Since the column role_id is AUTO INCREMENT, we don't need to mention the col in INSERT stmt
INSERT INTO `appy_poc`.`role`
(
`role_name`,
`role_description`)
VALUES
(
'patient',
'Patients in the application');

-- USER Table. ID is autoincrement. date_joined, last_login are not-null need to pass CURRENT_TIMESTAMP()
INSERT INTO `appy_poc`.`user`
(
`login`,
`firstname`,
`lastname`,
`password`,
`date_joined`,
`last_login`,
`email`,
`img_location`)
VALUES
(
'testuser1',
'test firstname',
'test lastname',
'password',
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP(),
'test@test.com',
'foo/bar/location/img.png');