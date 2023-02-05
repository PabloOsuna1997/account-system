INSERT INTO Account_Management.dbo.tblCurrency ( currency, description, user_registry, user_modified ) VALUES ('Q', 'Quezales', 'jposuna','jposuna'), ('D', 'Dolar', 'jposuna','jposuna');

INSERT INTO Account_Management.dbo.tblPerson_Type ( code, description , user_registry, user_modified ) VALUES ('INDIVIDUAL', 'Persona Individual', 'jposuna','jposuna'), ('EMPRESA', 'Persona Tipo empresa', 'jposuna','jposuna');

INSERT INTO Account_Management.dbo.tblGender  ( gender, description , user_registry, user_modified ) 
VALUES 
('F', 'Femenino', 'jposuna','jposuna'),
('M', 'Masculino', 'jposuna','jposuna');


INSERT INTO Account_Management.dbo.tblBussiness_status  (  name , discriminator , description  , user_registry, user_modified ) 
VALUES 
('ACT', 'User','Usuario activo en el sistema', 'jposuna', 'jposuna');
