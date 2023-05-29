CREATE TABLE IF NOT EXISTS articles_tags (
    a_t_id SERIAL NOT NULL PRIMARY KEY,
    a_id uuid NOT NULL,
    t_id int NOT NULL);