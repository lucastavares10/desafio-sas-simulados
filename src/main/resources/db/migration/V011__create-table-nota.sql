CREATE TABLE nota (
	id serial PRIMARY KEY,
	simulado_id BIGINT NOT NULL,
	aluno_id BIGINT NOT NULL,
	nota DECIMAL(10, 2),
	FOREIGN KEY (aluno_id) REFERENCES aluno(id),
	FOREIGN KEY (simulado_id) REFERENCES simulado(id)	
);









