--liquibase formatted sql
--changeset pkapela:1
CREATE TABLE "user" (
    "id" BIGSERIAL PRIMARY KEY,

    "email" VARCHAR(254) UNIQUE NOT NULL,
    "username" VARCHAR(30) UNIQUE NOT NULL,
    "description" VARCHAR(300),
    "password" TEXT NOT NULL,

    "created_at" TIMESTAMP WITH TIME ZONE NOT NULL,
    "deleted_at" TIMESTAMP WITH TIME ZONE
);