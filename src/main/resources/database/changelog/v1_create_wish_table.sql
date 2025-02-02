-- liquibase formatted sql
-- changeset fufn:1 stripComments:true splitStatements:true

CREATE TABLE wish
(
    id          UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name        VARCHAR(255),
    description TEXT,
    user_name  VARCHAR(255)
);