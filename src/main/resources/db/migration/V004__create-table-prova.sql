CREATE TABLE prova (
	id serial PRIMARY KEY,
	area_conhecimento VARCHAR(50) NOT NULL,
	finalizada BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO prova (area_conhecimento) VALUES ('FÍSICA');
INSERT INTO prova (area_conhecimento) VALUES ('BIOLOGIA');