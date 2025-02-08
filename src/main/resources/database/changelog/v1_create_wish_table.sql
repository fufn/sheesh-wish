-- liquibase formatted sql
-- changeset fufn:1 stripComments:true splitStatements:true

CREATE TABLE wish (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title TEXT NOT NULL,
    description TEXT,
    is_purchased BOOLEAN DEFAULT FALSE,
    username TEXT NOT NULL,
    price DOUBLE PRECISION,
    target_date TIMESTAMPTZ,
    image_url TEXT,
    product_url TEXT,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
