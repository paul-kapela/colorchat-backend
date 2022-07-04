--liquibase formatted sql
--changeset pkapela:2
CREATE TABLE "topic" (
    "id" BIGSERIAL PRIMARY KEY,

    "created_at" TIMESTAMP WITH TIME ZONE NOT NULL,
    "updated_at" TIMESTAMP WITH TIME ZONE,
    "deleted_at" TIMESTAMP WITH TIME ZONE
);

--changeset pkapela:3
CREATE TABLE "topic_user" (
    "topic_id" BIGINT NOT NULL,
    "user_id" BIGINT NOT NULL,

    PRIMARY KEY ("topic_id", "user_id"),

    CONSTRAINT "fk_topic" FOREIGN KEY("topic_id") REFERENCES "topic"("id")
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT "fk_user" FOREIGN KEY("user_id") REFERENCES  "user_"("id")
        ON UPDATE CASCADE
        ON DELETE CASCADE
);