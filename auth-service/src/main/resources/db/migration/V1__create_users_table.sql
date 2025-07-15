CREATE TABLE auth_users (
                       user_id UUID PRIMARY KEY,
                       user_role VARCHAR(20) NOT NULL DEFAULT 'ROLE_USER' ,
                       user_name VARCHAR (100) NOT NULL,
                       user_surname VARCHAR (150) NOT NULL,
                       user_email VARCHAR (150) UNIQUE,
                       user_password VARCHAR (200) NOT NULL,
                       user_phoneNumber VARCHAR(20),
                       user_dateOfBirth DATE,
                       user_createdTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                   );
