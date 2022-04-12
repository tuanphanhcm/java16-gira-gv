CREATE TABLE gira_program (
	ID 					VARCHAR ( 36 ) NOT NULL,
	created_at 			TIMESTAMP,
	created_by 			VARCHAR ( 36 ),
	last_modified_at 	TIMESTAMP,
	last_modified_by 	VARCHAR ( 36 ),
	VERSION 			INT4 NOT NULL,
	name 				VARCHAR(255) NOT NULL UNIQUE,
	program_type		VARCHAR(50) NOT NULL,
	module				VARCHAR(50) NOT NULL,
	description			VARCHAR(255) NOT NULL,
	PRIMARY KEY ( ID ) 
);

CREATE TABLE gira_role_program ( 
	role_id 			VARCHAR ( 36 ) NOT NULL, 
	program_id 			VARCHAR ( 36 ) NOT NULL, 
	PRIMARY KEY ( role_id, program_id ) 
);

ALTER TABLE IF EXISTS gira_role_program 
	ADD CONSTRAINT FK_ROLE FOREIGN KEY ( role_id ) REFERENCES gira_role(id);
ALTER TABLE IF EXISTS gira_role_program 
	ADD CONSTRAINT FK_PROGRAM FOREIGN KEY ( program_id ) REFERENCES gira_program(id);