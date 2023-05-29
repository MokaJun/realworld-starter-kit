CREATE TABLE IF NOT EXISTS follows (
    follow_id SERIAL NOT NULL PRIMARY KEY,
    follower_id uuid NOT NULL,
    following_id uuid NOT NULL);