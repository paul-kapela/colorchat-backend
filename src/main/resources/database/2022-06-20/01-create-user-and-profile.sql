--liquibase formatted sql
--changeset pkapela:1
CREATE TABLE "user" (
    "id" BIGSERIAL PRIMARY KEY,

    "email" VARCHAR(254) UNIQUE NOT NULL,
    "password" TEXT NOT NULL,

    "created_at" TIMESTAMP WITH TIME ZONE NOT NULL,
    "deleted_at" TIMESTAMP WITH TIME ZONE
);

--changeset pkapela:2
CREATE TABLE "profile" (
    "id" BIGSERIAL PRIMARY KEY,

    "user_id" BIGINT UNIQUE NOT NULL,

    "username" VARCHAR(30) UNIQUE NOT NULL,
    "description" VARCHAR(300),

    CONSTRAINT "fk_user" FOREIGN KEY ("user_id") REFERENCES "user"("id")
        ON UPDATE CASCADE
        ON DELETE CASCADE
);