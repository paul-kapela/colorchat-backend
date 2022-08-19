--liquibase formatted sql
--changeset pkapela:5
ALTER TABLE "topic"
    ADD COLUMN "type" CHAR(1);