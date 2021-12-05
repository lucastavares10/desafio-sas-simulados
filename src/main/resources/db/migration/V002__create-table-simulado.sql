CREATE TABLE simulado (
	id serial PRIMARY KEY,
	titulo VARCHAR(50) NOT NULL,
	nota DECIMAL(10, 2),
	data_criacao DATE
);


INSERT INTO simulado (titulo, data_criacao) VALUES ('Simulado 2020', '2020-06-10');
INSERT INTO simulado (titulo, data_criacao) VALUES ('Simulado 2021', '2021-06-10');
INSERT INTO simulado (titulo, data_criacao) VALUES ('Simulado 2022', '2022-06-10');
INSERT INTO simulado (titulo, data_criacao) VALUES ('Simulado 2023', '2023-06-10');

