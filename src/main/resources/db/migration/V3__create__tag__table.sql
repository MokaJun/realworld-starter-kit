CREATE TABLE IF NOT EXISTS tags (
    tag_id SERIAL NOT NULL,
    tag_name uuid NOT NULL unique);