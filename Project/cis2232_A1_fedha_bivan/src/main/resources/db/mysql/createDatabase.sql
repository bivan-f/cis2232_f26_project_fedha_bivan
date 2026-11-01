CREATE DATABASE pokemon;

USE pokemon;

CREATE TABLE pokemon_card (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    type VARCHAR(50),
    hit_points INT,
    attack_name VARCHAR(100),
    attack_damage INT
);