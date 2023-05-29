CREATE TABLE IF NOT EXISTS tags (
    tag_id SERIAL NOT NULL PRIMARY KEY,
    tag_name uuid NOT NULL unique);