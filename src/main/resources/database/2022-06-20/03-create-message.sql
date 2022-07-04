--liquibase formatted sql
--changeset pkapela:4
CREATE TABLE "message" (
    "id" BIGSERIAL PRIMARY KEY,

    "user_id" BIGINT NOT NULL,
    "topic_id" BIGINT NOT NULL,

    "content" VARCHAR(20000) NOT NULL,

    "created_at" TIMESTAMP WITH TIME ZONE NOT NULL,
    "updated_at" TIMESTAMP WITH TIME ZONE,
    "read_at" TIMESTAMP WITH TIME ZONE,
    "deleted_at" TIMESTAMP WITH TIME ZONE,

    CONSTRAINT "fk_user" FOREIGN KEY ("user_id") REFERENCES "user_"("id")
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT "fk_topic" FOREIGN KEY ("topic_id") REFERENCES "topic"("id")
        ON UPDATE CASCADE
        ON DELETE CASCADE
);