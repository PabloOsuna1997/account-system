
INSERT INTO Account_Management.dbo.tblCurrency ( currency, description, user_registry, user_modified ) VALUES ('Q', 'Quezales', 'sysdba','sysdba'), ('D', 'Dolar', 'sysdba','sysdba');

INSERT INTO Account_Management.dbo.tblPerson_Type ( code, description , user_registry, user_modified ) VALUES ('INDIVIDUAL', 'Persona Individual', 'sysdba','sysdba'), ('EMPRESA', 'Persona Tipo empresa', 'sysdba','sysdba');

INSERT INTO Account_Management.dbo.tblGender  ( gender, description , user_registry, user_modified ) 
VALUES 
('F', 'Femenino', 'sysdba','sysdba'),
('M', 'Masculino', 'sysdba','sysdba');

INSERT INTO Account_Management.dbo.tblAccount_Type (name, description, user_registry, user_modified)
VALUES
('MONETARIA', 'CUENTA MONETARIA', 'sysdba', 'sysdba'),
('AHORRO', 'CUENTA AHORRO', 'sysdba', 'sysdba');


INSERT INTO Account_Management.dbo.tblBussiness_status  (  name , discriminator , description  , user_registry, user_modified ) 
VALUES 
('ACT', 'User','Usuario activo en el sistema', 'sysdba', 'sysdba'),
('DESC', 'User','Usuario inactivo en el sistema', 'sysdba', 'sysdba');
