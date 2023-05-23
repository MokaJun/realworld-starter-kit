CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(45) NOT NULL PRIMARY KEY,
    email VARCHAR(45) NOT NULL unique,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    token VARCHAR(45),
    bio VARCHAR(80),
    image VARCHAR(80) DEFAULT NULL
    );