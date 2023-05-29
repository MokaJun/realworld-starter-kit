CREATE TABLE IF NOT EXISTS articles (
    article_id SERIAL NOT NULL PRIMARY KEY,
    slug VARCHAR(50) NOT NULL,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    body VARCHAR(500),
    created_at timestamp,
    updated_at timestamp,
    author uuid NOT NULL);