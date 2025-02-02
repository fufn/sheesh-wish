-- liquibase formatted sql
-- changeset fufn:1 stripComments:true splitStatements:true

CREATE TABLE wish
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, 
    name        VARCHAR(255) NOT NULL,                           
    description TEXT,                                            
    user_email  VARCHAR(255)                                     
);