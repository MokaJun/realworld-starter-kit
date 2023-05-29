CREATE TABLE IF NOT EXISTS articles_tags (
    a_t_id SERIAL NOT NULL,
    a_id uuid NOT NULL,
    t_id int NOT NULL);