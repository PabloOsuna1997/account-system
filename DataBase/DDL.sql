
CREATE DATABASE Account_Management;
USE Account_Management;

CREATE TABLE tblCurrency(
	currency CHAR NOT NULL,
	dbid INT NOT NULL IDENTITY(1,1),
	description VARCHAR(50) NOT NULL, 	
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid)
);


CREATE TABLE tblAccount_Type(
	dbid INT NOT NULL IDENTITY(1,1),
	name VARCHAR(50) NOT NULL,
	description VARCHAR(100) NOT NULL, 	
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid)
);

CREATE TABLE tblPerson_Type(
	dbid INT NOT NULL  IDENTITY(1,1),
	code VARCHAR(50) NOT NULL,
	description VARCHAR(100) NOT NULL, 	
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid)
);

CREATE TABLE tblGender(
	dbid INT NOT NULL IDENTITY(1,1),
	gender VARCHAR(50) NOT NULL,
	description VARCHAR(100) NOT NULL, 	
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid)
);


CREATE TABLE tblBussiness_status(
	dbid INT NOT NULL IDENTITY(1,1),
	name VARCHAR(50) NOT NULL,
	discriminator VARCHAR(50) NOT NULL,
	description VARCHAR(100) NOT NULL, 	
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid)
);

CREATE TABLE tblCountry(
	dbid INT NOT NULL IDENTITY(1,1),
	name VARCHAR(100) NOT NULL,
	country_code VARCHAR(50) NOT NULL,
	status INT NOT NUll,
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid),
	CONSTRAINT FK_Status_Country FOREIGN KEY (status) REFERENCES tblBussiness_status(dbid)
);

CREATE TABLE tblCity(
	dbid INT NOT NULL IDENTITY(1,1),
	name VARCHAR(100) NOT NULL,
	city_code VARCHAR(50) NOT NULL,
	status INT NOT NUll,
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid),
	CONSTRAINT FK_Status_City FOREIGN KEY (status) REFERENCES tblBussiness_status(dbid)
);

CREATE TABLE tblState(
	dbid INT NOT NULL IDENTITY(1,1),
	name VARCHAR(100) NOT NULL,
	state_code VARCHAR(50) NOT NULL,
	status INT NOT NUll,
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid),
	CONSTRAINT FK_Status_State FOREIGN KEY (status) REFERENCES tblBussiness_status(dbid)
);

CREATE TABLE tblZone(
	dbid INT NOT NULL IDENTITY(1,1),
	name VARCHAR(100) NOT NULL,
	zone_code VARCHAR(50) NOT NULL,
	status INT NOT NUll,
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid),
	CONSTRAINT FK_Status_Zone FOREIGN KEY (status) REFERENCES tblBussiness_status(dbid)
);


CREATE TABLE tblClient(
	dbid INT NOT NULL IDENTITY(1,1),
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	cui BIGINT NOT NUll,
	nit VARCHAR(10) NOT NULL,
	phone_number BIGINT,
	email_address VARCHAR(100), 
	gender INT NOT NULL,
	birthay DATETIME NOT NULL,   -- se agrego campo
	person_type INT NOT NULL,
	marial_status INT NOT NULL,
	status INT NOT NULL,
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid),
	CONSTRAINT FK_Gender_Client FOREIGN KEY (gender) REFERENCES tblGender(dbid),
	CONSTRAINT FK_Person_Type_Client FOREIGN KEY (gender) REFERENCES tblPerson_Type(dbid),
	CONSTRAINT FK_Status_Client FOREIGN KEY (status) REFERENCES tblBussiness_status(dbid)
);


CREATE TABLE tblClient_Address(
	dbid INT NOT NULL IDENTITY(1,1),
	client_id INT NOT NULL,
	country_id INT NOT NULL, 
	city_id INT NOT NULL,
	state_id INT NOT NULL,
	zone_id INT NOT NULL,
	complement_address VARCHAR(250),
	status INT NOT NULL,
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid),
	CONSTRAINT FK_Client_Id_Client_Address FOREIGN KEY (client_id) REFERENCES tblClient(dbid),
	CONSTRAINT FK_Country_Id_Client_Address FOREIGN KEY (country_id) REFERENCES tblCountry(dbid),
	CONSTRAINT FK_State_Id_Client_Address FOREIGN KEY (state_id) REFERENCES tblState(dbid),
	CONSTRAINT FK_Zone_Id_Client_Address FOREIGN KEY (zone_id) REFERENCES tblZone(dbid)
);


CREATE TABLE tblAccount(
	dbid INT NOT NULL IDENTITY(1,1),
	client_id INT NOT NULL,
	amount DECIMAL DEFAULT 0 NOT NULL, 
	init_vig DATETIME NOT NULL,
	fin_vig DATETIME NOT NULL,
	currency INT NOT NULL,
	account_type INT  NOT NULL,
	status INT NOT NULL,
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid),
	CONSTRAINT FK_Client_Id_Account FOREIGN KEY (client_id) REFERENCES tblClient(dbid),
	CONSTRAINT FK_Currency_Account FOREIGN KEY (currency) REFERENCES tblCurrency(dbid),
	CONSTRAINT FK_Account_Type_Account FOREIGN KEY (account_type) REFERENCES tblAccount_Type(dbid),
	CONSTRAINT FK_Status_Account FOREIGN KEY (status) REFERENCES tblBussiness_status(dbid)
);

CREATE TABLE tblCheck_Book(
	dbid INT NOT NULL IDENTITY(1,1),
	account_id INT NOT NULL, 
	start_correlative BIGINT NOT NULL,
	fin_correlative BIGINT NOT NULL,
	quantity_checks INT NOT NULL,
	status INT NOT NULL,
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid),
	CONSTRAINT FK_Account_Id_Check_Book FOREIGN KEY (account_id) REFERENCES tblAccount(dbid),
	CONSTRAINT FK_status_Check_Book FOREIGN KEY (status) REFERENCES tblBussiness_status(dbid)
);


CREATE TABLE tblCheck_Issued(
	dbid INT NOT NULL IDENTITY(1,1),
	check_book_id INT NOT NULL, 
	amount DECIMAL NOT NULL,
	bearer_name VARCHAR(100) NOT NULL,
	date_emission DATETIME NOT NULL,
	pay_day DATETIME NOT NULL,
	status INT NOT NULL,
	registry_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_registry VARCHAR(100) NOT NULL,
	last_modified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	user_modified VARCHAR(100) NOT NULL,
	PRIMARY KEY (dbid),
	CONSTRAINT FK_Check_Book_Id_Check_Issued FOREIGN KEY (check_book_id) REFERENCES tblCheck_Book(dbid),
	CONSTRAINT FK_Status_Check_Issued FOREIGN KEY (status) REFERENCES tblBussiness_status(dbid)
);


