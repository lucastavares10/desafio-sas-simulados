CREATE TABLE aluno (
	id serial PRIMARY KEY,
	nome VARCHAR(70) NOT NULL,
	cpf VARCHAR(20) NOT NULL
);


INSERT INTO aluno (nome, cpf) VALUES ('João da Silva Santos', '11111111111');
INSERT INTO aluno (nome, cpf) VALUES ('Maria Joaquina de Souza', '22222222222');
INSERT INTO aluno (nome, cpf) VALUES ('Chico Charles Xavier', '333333333333');
INSERT INTO aluno (nome, cpf) VALUES ('Logan Cícero da Silva', '44444444444');