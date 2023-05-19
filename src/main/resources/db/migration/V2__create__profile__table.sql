CREATE TABLE IF NOT EXISTS profiles (
    following_id SERIAL NOT NULL,
    email VARCHAR(45) NOT NULL,
    following VARCHAR(45) NOT NULL,
    PRIMARY KEY (following_id),
    CONSTRAINT fk_user
        FOREIGN KEY (email)
            REFERENCES users (email)
            ON DELETE CASCADE
            ON UPDATE CASCADE);