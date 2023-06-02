-- show databases;
-- create database real_world;
-- use real_world;
-- SELECT DATABASE();

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
                                     user_id SERIAL PRIMARY KEY,
                                     email VARCHAR(45) NOT NULL unique,
                                     username VARCHAR(45) NOT NULL unique,
                                     password VARCHAR(45) NOT NULL,
                                     bio VARCHAR(80),
                                     image VARCHAR(80) DEFAULT NULL
);

INSERT INTO users (user_id, email, username, password, bio) VALUES (1, '1296@gmail.com', 1296, '1296', NOW());
INSERT INTO users (email, username, password, bio) VALUES ('155@gmail.com', 155, '155', NOW());

DROP TABLE IF EXISTS follows;
CREATE TABLE IF NOT EXISTS follows (
                                       follow_id SERIAL PRIMARY KEY,
                                       follower_id bigint NOT NULL,
                                       following_id bigint NOT NULL);

INSERT INTO follows (follower_id, following_id) VALUES (1, 2);

DROP TABLE IF EXISTS tags;
CREATE TABLE IF NOT EXISTS tags (
                                    tag_id SERIAL PRIMARY KEY,
                                    tag_name VARCHAR(45) NOT NULL unique);

DROP TABLE IF EXISTS articles;
CREATE TABLE IF NOT EXISTS articles (
                                        article_id SERIAL PRIMARY KEY,
                                        slug VARCHAR(50) NOT NULL,
                                        title VARCHAR(50) NOT NULL,
                                        description VARCHAR(100),
                                        body VARCHAR(500),
                                        created_at timestamp,
                                        updated_at timestamp,
                                        author bigint NOT NULL);


DROP TABLE IF EXISTS articles_tags;
CREATE TABLE IF NOT EXISTS articles_tags (
                                             a_t_id SERIAL PRIMARY KEY,
                                             a_id bigint NOT NULL,
                                             t_id bigint NOT NULL);

